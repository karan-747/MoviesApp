package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.MovieItem

interface MovieRepository {
    suspend fun getMovies ():List<MovieItem>?

    suspend fun updateMovies():List<MovieItem>?

}