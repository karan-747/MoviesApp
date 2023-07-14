package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecase.GetMovieList
import com.example.moviesapp.domain.usecase.UpdateMovieList

class MoviesViewModel (private val getMovieUseCase: GetMovieList,
            private val updateMovieList: UpdateMovieList )  :ViewModel(){


        fun getMovies()  = liveData {
            val movies = getMovieUseCase.execute()
            emit(movies)
        }

        fun updateMovies () = liveData {
            val movies = updateMovieList.execute()
            emit(movies)
        }



}