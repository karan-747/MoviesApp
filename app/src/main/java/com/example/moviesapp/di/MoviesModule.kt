package com.example.moviesapp.di

import com.example.moviesapp.presentation.MoviesVMFactory
import com.example.moviesapp.domain.usecase.GetMovieList
import com.example.moviesapp.domain.usecase.UpdateMovieList
import dagger.Module
import dagger.Provides


@Module
class MoviesModule {

    @MoviesScope
    @Provides
    fun providesMoviesVMFactory(getMoviesList: GetMovieList, updateMovieList: UpdateMovieList): MoviesVMFactory {
        return MoviesVMFactory(getMoviesList,updateMovieList)
    }

}