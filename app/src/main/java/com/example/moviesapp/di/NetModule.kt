package com.example.moviesapp.di

import com.example.moviesapp.data.api.TMDBInterface
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetModule(private val baseURL:String) {

    @Singleton
    @Provides
    fun providesRetrofit( ): Retrofit{

        return  Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL).build()
    }

    @Singleton
    @Provides
    fun getTMDBService (retrofit: Retrofit): TMDBInterface {
        return  retrofit.create(TMDBInterface::class.java)
    }
}