package com.example.moviesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "popular_movies")
data class MovieItem(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("original_title")
    val movieName : String,
    @SerializedName("overview")
    val movieDescription: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val movieReleaseDate: String,

    @SerializedName("vote_average")
    val movieRating:Float

)