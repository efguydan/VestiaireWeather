package com.efedaniel.vestiaireweather.presentation.weather.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.efedaniel.vestiaireweather.data.persistence.database.entities.WeatherEntity
import com.efedaniel.vestiaireweather.domain.mappers.WeatherMapper
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.domain.repositories.WeatherRepository
import com.efedaniel.vestiaireweather.presentation.base.BaseViewModel
import com.efedaniel.vestiaireweather.data.network.utils.LoadingStatus
import com.efedaniel.vestiaireweather.data.network.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherListViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: WeatherMapper
): BaseViewModel() {

    private val _weatherList: LiveData<List<WeatherEntity>> = repository.observeWeathers()

    val weatherList: LiveData<List<Weather>> = Transformations.map(_weatherList) {
        it.map { entity -> mapper.mapEntityToDomain(entity) }
    }

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