package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MoviesCacheDataSource
import com.example.moviesapp.data.datasource.MoviesLocalDataSource
import com.example.moviesapp.data.datasource.MoviesRemoteDataSource
import com.example.moviesapp.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MovieRepositoryModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(
        movieRemoteDataSource: MoviesRemoteDataSource,
        moviesLocalDataSource: MoviesLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource
    ) : MoviesRepository {
        return MoviesRepository(moviesCacheDataSource,
            movieRemoteDataSource
            ,moviesLocalDataSource)
    }
}