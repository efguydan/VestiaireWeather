package com.efedaniel.vestiaireweather.domain.repositories

import androidx.lifecycle.LiveData
import com.efedaniel.vestiaireweather.data.network.services.WeatherService
import com.efedaniel.vestiaireweather.data.persistence.database.daos.WeatherDao
import com.efedaniel.vestiaireweather.data.persistence.database.entities.WeatherEntity
import com.efedaniel.vestiaireweather.domain.mappers.WeatherMapper
import com.efedaniel.vestiaireweather.data.network.utils.GENERIC_ERROR_CODE
import com.efedaniel.vestiaireweather.data.network.utils.GENERIC_ERROR_MESSAGE
import com.efedaniel.vestiaireweather.data.network.utils.Result
import com.efedaniel.vestiaireweather.data.network.utils.getAPIResult
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val network: WeatherService,
    private val persistence: WeatherDao,
    private val mapper: WeatherMapper
) {

    suspend fun fetchWeatherForecast(): Result<Boolean> {
        return try {
            when (val result = getAPIResult(network.getWeatherForecast())) {
                is Result.Success -> {
                    persistence.clearTable()
                    persistence.insert(result.data.weathers.map { mapper.mapDtoToEntity(it) })
                    Result.Success(true)
                }
                is Result.Error -> Result.Error(result.errorCode, result.errorMessage)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is IOException) {
                //  Network Error
                Result.Error(
                    GENERIC_ERROR_CODE,
                    "No Internet Connection. Displaying Cached Results"
                )
            } else {
                Result.Error(GENERIC_ERROR_CODE, GENERIC_ERROR_MESSAGE)
            }
        }
    }

    fun observeWeathers(): LiveData<List<WeatherEntity>> = persistence.observeAllWeather()

}