package com.efedaniel.vestiaireweather.presentation.weather.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.domain.repositories.WeatherRepository
import com.efedaniel.vestiaireweather.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherDetailsViewModel @Inject constructor(
    private val repository: WeatherRepository,
): BaseViewModel() {

    private val _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather> = _weather

    fun setWeatherId(id: Long) {
        viewModelScope.launch {
            _weather.postValue(repository.getWeatherByID(id))
        }
    }

}