package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.MoviesList
import retrofit2.Response

interface MoviesRemoteDataSource {

    suspend fun getMovies():Response<MoviesList>
}