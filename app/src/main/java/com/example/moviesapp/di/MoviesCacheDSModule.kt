package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MoviesCacheDataSource
import com.example.moviesapp.data.datasourceImpl.MoviesCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesCacheDSModule {

    @Singleton
    @Provides
    fun getMoviesCacheDS(): MoviesCacheDataSource {
        return MoviesCacheDataSourceImpl()
    }


}