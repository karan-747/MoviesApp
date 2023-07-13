package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.MoviesList

interface MoviesCacheDataSource {

    suspend fun getMoviesFromCache():List<MovieItem>

    suspend fun saveMoviesToCache(moviesList: List<MovieItem>)
}