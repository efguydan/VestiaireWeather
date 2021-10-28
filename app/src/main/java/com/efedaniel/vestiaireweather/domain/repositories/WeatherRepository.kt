package com.efedaniel.vestiaireweather.domain.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.efedaniel.vestiaireweather.data.network.services.WeatherService
import com.efedaniel.vestiaireweather.data.network.utils.GENERIC_ERROR_CODE
import com.efedaniel.vestiaireweather.data.network.utils.GENERIC_ERROR_MESSAGE
import com.efedaniel.vestiaireweather.data.network.utils.Result
import com.efedaniel.vestiaireweather.data.network.utils.getAPIResult
import com.efedaniel.vestiaireweather.data.persistence.database.daos.WeatherDao
import com.efedaniel.vestiaireweather.domain.mappers.WeatherMapper
import com.efedaniel.vestiaireweather.domain.models.Weather
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val network: WeatherService,
    private val persistence: WeatherDao,
    private val mapper: WeatherMapper
) {

    /**
     * Method to fetch the weather forecast and update the database with the data gotten.
     */
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

    /**
     * Method to observe the list of weather in the database. Will be updated if any data changes
     * in the table.
     */
    fun observeAllWeather(): LiveData<List<Weather>> {
        return Transformations.map(persistence.observeAllWeather()) {
            it.map { entity -> mapper.mapEntityToDomain(entity) }
        }
    }

    /**
     * Method to get a weather object in the database with its ID
     */
    suspend fun getWeatherByID(id: Long): Weather = mapper
        .mapEntityToDomain(
            persistence.getWeatherByID(id)
        )
}
