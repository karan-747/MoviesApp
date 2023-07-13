package com.example.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.MovieItem


@Dao
interface MovieDAO {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<MovieItem>)


    @Query("DELETE FROM popular_movies")
    suspend fun deleteMovies()


    @Query("SELECT * FROM popular_movies")
    suspend fun getAllMovies():List<MovieItem>


}