package com.efedaniel.vestiaireweather

import android.app.Application
import com.efedaniel.vestiaireweather.di.AppComponent
import com.efedaniel.vestiaireweather.di.DaggerAppComponent

class VestiaireWeatherApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}
