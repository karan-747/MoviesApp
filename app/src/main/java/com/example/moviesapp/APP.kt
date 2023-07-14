package com.example.moviesapp

import android.app.Application

import com.example.moviesapp.data.api.CONSTANTS
import com.example.moviesapp.di.AppComponent
import com.example.moviesapp.di.AppModule
import com.example.moviesapp.di.DaggerAppComponent
//import com.example.moviesapp.di.DaggerAppComponent

import com.example.moviesapp.di.Injector
import com.example.moviesapp.di.MoviesRemoteDSModule
import com.example.moviesapp.di.MoviesSubComponent
import com.example.moviesapp.di.NetModule
import dagger.Component




class APP:Application(),Injector {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().
                appModule(AppModule(applicationContext)).netModule(NetModule(CONSTANTS.BASE_URL))
            .moviesRemoteDSModule(MoviesRemoteDSModule(CONSTANTS.API_KEY))
            .build()


    }
    override fun createMovieSubComponent(): MoviesSubComponent {
        return appComponent.moviesSubComponent().create()
    }


}