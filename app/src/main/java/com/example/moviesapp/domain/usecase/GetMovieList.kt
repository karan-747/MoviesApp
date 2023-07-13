package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.domain.repository.MovieRepository

class GetMovieList (private val movieRepository: MovieRepository) {

    suspend fun execute( ):List<MovieItem>?{
        return movieRepository.getMovies()
    }
}