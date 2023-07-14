package com.example.moviesapp.di

import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.repository.MoviesRepository
import com.example.moviesapp.domain.usecase.GetMovieList
import com.example.moviesapp.domain.usecase.UpdateMovieList
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCaseModule {



    @Provides
    fun providesGetMovieUseCase(movieRepository:MoviesRepository):GetMovieList{
        return  GetMovieList(movieRepository)
    }


    @Provides
    fun providesUpdateMovieList(movieRepository:MoviesRepository):UpdateMovieList{
        return UpdateMovieList(movieRepository)
    }
}