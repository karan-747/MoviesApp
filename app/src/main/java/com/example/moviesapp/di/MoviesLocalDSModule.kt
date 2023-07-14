package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MoviesLocalDataSource
import com.example.moviesapp.data.db.TMDBDatabase
import com.example.moviesapp.data.datasourceImpl.MoviesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MoviesLocalDSModule {

    @Singleton
    @Provides
    fun getMoviesLocalDS(tmdbDatabase: TMDBDatabase):MoviesLocalDataSource{
        return  MoviesLocalDataSourceImpl(tmdbDatabase.getMovieDao())
    }

}