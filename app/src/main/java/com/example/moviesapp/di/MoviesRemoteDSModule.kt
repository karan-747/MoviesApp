package com.example.moviesapp.di

import com.example.moviesapp.data.api.TMDBInterface
import com.example.moviesapp.data.datasource.MoviesRemoteDataSource
import com.example.moviesapp.data.datasourceImpl.MoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesRemoteDSModule (private val apiKey:String){


    @Singleton
    @Provides
    fun getRemoteDS(tmdbInterface: TMDBInterface): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(tmdbInterface, apiKey )
    }
}