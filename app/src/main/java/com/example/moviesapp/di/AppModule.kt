package com.example.moviesapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents =  [MoviesSubComponent::class])
class AppModule (private val myContext:Context){

    @Singleton
    @Provides
    fun providesApplicationContext():Context{
        return  myContext.applicationContext
    }

}