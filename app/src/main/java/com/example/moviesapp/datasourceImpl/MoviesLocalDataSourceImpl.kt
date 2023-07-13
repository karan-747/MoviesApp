package com.example.moviesapp.datasourceImpl

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.datasource.MoviesLocalDataSource
import com.example.moviesapp.data.db.MovieDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesLocalDataSourceImpl(private val moviesDa0 :MovieDAO ) :MoviesLocalDataSource{
    override suspend fun getMoviesFromDB(): List<MovieItem> {

        return moviesDa0.getAllMovies()
    }

    override suspend fun saveMovies(movies: List<MovieItem>) {

        CoroutineScope(Dispatchers.IO).launch {
            moviesDa0.saveMovies(movies)
        }

    }

    override suspend fun clearAll() {


        CoroutineScope(Dispatchers.IO).launch {
            moviesDa0.deleteMovies()
        }
    }
}