package com.efedaniel.vestiaireweather.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.efedaniel.vestiaireweather.presentation.weather.details.WeatherDetailsViewModel
import com.efedaniel.vestiaireweather.presentation.weather.list.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherListViewModel::class)
    abstract fun bindWeatherListViewModel(viewModel: WeatherListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailsViewModel::class)
    abstract fun bindWeatherDetailsViewModel(viewModel: WeatherDetailsViewModel): ViewModel
}
