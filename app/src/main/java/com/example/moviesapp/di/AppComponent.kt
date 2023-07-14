package com.example.moviesapp.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
                        AppModule::class,
                    DatabaseModule::class,
                    MoviesLocalDSModule::class,
                    MoviesRemoteDSModule::class,
                    NetModule::class,
                    UseCaseModule::class,
                    MovieRepositoryModule::class,
                    MoviesCacheDSModule::class

                    ]
)
interface AppComponent {
    fun moviesSubComponent():MoviesSubComponent.Factory
}