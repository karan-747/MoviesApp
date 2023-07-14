package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.data.db.MovieDAO
import com.example.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(myContext : Context):TMDBDatabase{
        return Room.databaseBuilder(myContext,
            TMDBDatabase::class.java,
            "movies_database").build()
    }

    @Singleton
    @Provides
    fun proviedsMovieDA0(tmdbDatabase: TMDBDatabase):MovieDAO{
        return  tmdbDatabase.getMovieDao()
    }


}