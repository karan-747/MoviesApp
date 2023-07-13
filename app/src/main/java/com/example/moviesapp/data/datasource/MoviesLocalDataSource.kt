package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.MovieItem

interface MoviesLocalDataSource {

    suspend fun getMoviesFromDB():List<MovieItem>

    suspend fun saveMovies(movies:List<MovieItem>)

    suspend fun  clearAll()

}