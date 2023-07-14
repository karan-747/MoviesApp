package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.domain.usecase.GetMovieList
import com.example.moviesapp.domain.usecase.UpdateMovieList
import java.lang.IllegalArgumentException



class MoviesVMFactory(private val getMovieUseCase: GetMovieList,
                      private val updateMovieList: UpdateMovieList
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesViewModel::class.java)){
            return MoviesViewModel(getMovieUseCase,updateMovieList) as T
        }
        throw IllegalArgumentException("No valid ViewModel Class Found")
    }
}