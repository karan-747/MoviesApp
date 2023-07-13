package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.MoviesList
import com.example.moviesapp.data.datasource.MoviesCacheDataSource
import com.example.moviesapp.data.datasource.MoviesRemoteDataSource
import com.example.moviesapp.datasourceImpl.MoviesLocalDataSourceImpl
import java.lang.Exception

class MoviesRepository(
    private val moviesCacheDataSource: MoviesCacheDataSource,
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSourceImpl: MoviesLocalDataSourceImpl
):MovieRepository {
    override suspend fun getMovies(): List<MovieItem>? {
        return getMoviesFromCache()
    }



    override suspend fun updateMovies(): List<MovieItem>? {
        val newMoviesList = getMoviesFromApi()
        moviesLocalDataSourceImpl.clearAll()
        moviesLocalDataSourceImpl.saveMovies(newMoviesList)
        moviesCacheDataSource.saveMoviesToCache(newMoviesList)
        return newMoviesList

    }

    private suspend fun getMoviesFromApi(): List<MovieItem> {
        lateinit var moviesList: List<MovieItem>
        try {
            val response = moviesRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                moviesList = body.movies
            }
        }
        catch (e:Exception){

        }
        return moviesList
    }
    private suspend fun getMoviesFromRoom():List<MovieItem>{
        lateinit var moviesList: List<MovieItem>
        try {
            moviesList = moviesLocalDataSourceImpl.getMoviesFromDB()
        }
        catch (e:Exception){

        }
        return if(moviesList.isEmpty()){
            moviesLocalDataSourceImpl.clearAll()
            moviesLocalDataSourceImpl.saveMovies(moviesList)
            moviesList
        }else{
            moviesList
        }
    }

    private suspend fun getMoviesFromCache(): List<MovieItem>? {
        lateinit var moviesList: List<MovieItem>
        try {
            moviesList = moviesCacheDataSource.getMoviesFromCache()
        }
        catch (e:Exception){

        }
        return if(moviesList.isNotEmpty()){
            moviesList
        } else{
            moviesList = getMoviesFromRoom()
            moviesCacheDataSource.saveMoviesToCache(moviesList)
            moviesList
        }
    }
}