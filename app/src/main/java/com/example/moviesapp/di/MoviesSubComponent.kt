package com.example.moviesapp.di

import com.example.moviesapp.presentation.fragments.MoviesFragment
import dagger.Subcomponent


//DatabaseModule::class,MovieRepositoryModule::class,MoviesCacheDSModule::class,
//                MoviesLocalDSModule::class ,
//,MoviesRemoteDSModule::class, UseCaseModule::class]

@MoviesScope
@Subcomponent(modules =  [ MoviesModule::class])
interface MoviesSubComponent {

    fun inject(moviesFragment: MoviesFragment)


    @Subcomponent.Factory
    interface Factory{
        fun create():MoviesSubComponent
    }


}