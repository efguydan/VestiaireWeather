package com.efedaniel.vestiaireweather.di

import android.app.Application
import com.efedaniel.vestiaireweather.presentation.weather.details.WeatherDetailsFragment
import com.efedaniel.vestiaireweather.presentation.weather.list.WeatherListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIServiceModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(target: WeatherListFragment)
    fun inject(target: WeatherDetailsFragment)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(app: Application): Builder
    }
}
