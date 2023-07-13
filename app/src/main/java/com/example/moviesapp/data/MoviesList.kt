package com.example.moviesapp.data

import com.google.gson.annotations.SerializedName

data class MoviesList(


    @SerializedName("results")
    val movies:List<MovieItem>
)
