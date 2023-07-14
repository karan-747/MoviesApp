package com.example.moviesapp.domain.repository

import android.util.Log
import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.datasource.MoviesCacheDataSource
import com.example.moviesapp.data.datasource.MoviesLocalDataSource
import com.example.moviesapp.data.datasource.MoviesRemoteDataSource
import java.lang.Exception

class MoviesRepository(
    private val moviesCacheDataSource: MoviesCacheDataSource,
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource
):MovieRepository {
    override suspend fun getMovies(): List<MovieItem>? {
        return getMoviesFromCache()
    }



    override suspend fun updateMovies(): List<MovieItem>? {
        val newMoviesList = getMoviesFromApi()
        moviesLocalDataSource.clearAll()
        moviesLocalDataSource.saveMovies(newMoviesList)
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
            else{
                moviesList = listOf()
            }
            Log.d("TAGY",response.message())
        }
        catch (e:Exception){
            moviesList = listOf()
            Log.d("TAGY", e.message.toString())
        }
        return moviesList
    }
    private suspend fun getMoviesFromRoom():List<MovieItem>{
        lateinit var moviesList: List<MovieItem>
        try {
            moviesList = moviesLocalDataSource.getMoviesFromDB()
        }
        catch (e:Exception){
            moviesList = listOf()
        }
        return if(moviesList.isEmpty()){
            moviesList = getMoviesFromApi()
            moviesLocalDataSource.clearAll()
            moviesLocalDataSource.saveMovies(moviesList)
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
            moviesList = listOf()
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