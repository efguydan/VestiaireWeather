package com.efedaniel.vestiaireweather

import android.app.Application
import com.efedaniel.vestiaireweather.di.AppComponent
import com.efedaniel.vestiaireweather.di.DaggerAppComponent
import timber.log.Timber

class VestiaireWeatherApp: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}