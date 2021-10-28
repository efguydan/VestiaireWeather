package com.efedaniel.vestiaireweather.presentation.weather.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.efedaniel.vestiaireweather.data.network.utils.LoadingStatus
import com.efedaniel.vestiaireweather.data.network.utils.Result
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.domain.repositories.WeatherRepository
import com.efedaniel.vestiaireweather.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherListViewModel @Inject constructor(
    private val repository: WeatherRepository,
): BaseViewModel() {

    val weatherList: LiveData<List<Weather>> = repository.observeAllWeather()

    init {
        fetchWeatherForecasts()
    }

    private fun fetchWeatherForecasts() {
        _loadingStatus.setValue(LoadingStatus.Loading())
        viewModelScope.launch {
            when (val result = repository.fetchWeatherForecast()) {
                is Result.Success -> {
                    _loadingStatus.setValue(LoadingStatus.Success)
                }
                is Result.Error -> {
                    _loadingStatus.setValue(LoadingStatus.Error(result.errorMessage))
                }
            }
        }
    }

}