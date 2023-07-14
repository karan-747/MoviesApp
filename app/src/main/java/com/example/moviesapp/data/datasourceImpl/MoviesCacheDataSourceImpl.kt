package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.data.MoviesList
import com.example.moviesapp.data.datasource.MoviesCacheDataSource

class MoviesCacheDataSourceImpl:MoviesCacheDataSource  {
    private val movieList = ArrayList<MovieItem>()
    override suspend fun getMoviesFromCache(): List<MovieItem> {
        return movieList
    }

    override suspend fun saveMoviesToCache(moviesList: List<MovieItem>) {
        this.movieList.clear()
        this.movieList.addAll(movieList)
    }





}