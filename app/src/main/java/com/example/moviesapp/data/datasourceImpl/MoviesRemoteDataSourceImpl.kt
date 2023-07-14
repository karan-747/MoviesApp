package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.MoviesList
import com.example.moviesapp.data.api.TMDBInterface
import com.example.moviesapp.data.datasource.MoviesRemoteDataSource
import retrofit2.Response

class MoviesRemoteDataSourceImpl(private val tmdbService:TMDBInterface,
                                 private val apiKey:String):MoviesRemoteDataSource {
    override suspend fun getMovies(): Response<MoviesList> {
        return tmdbService.getPopularMovies(apiKey)

    }

}