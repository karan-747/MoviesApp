package com.example.moviesapp.data.api

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBInterface {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String):Response<MoviesList>
}