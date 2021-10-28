package com.efedaniel.vestiaireweather.domain.mappers

import com.efedaniel.vestiaireweather.data.network.dtos.WeatherDto
import com.efedaniel.vestiaireweather.data.persistence.database.entities.WeatherEntity
import com.efedaniel.vestiaireweather.domain.models.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun mapDtoToEntity(dto: WeatherDto): WeatherEntity {
        return WeatherEntity(
            id = null,
            dt = dto.dt,
            sunrise = dto.sunrise,
            sunset = dto.sunset,
            pressure = dto.pressure,
            humidity = dto.humidity,
            speed = dto.speed,
            deg = dto.deg,
            gust = dto.gust,
            clouds = dto.clouds,
            pop = dto.pop,
            minTemperature = dto.temperature.min,
            maxTemperature = dto.temperature.max,
            dayTemperature = dto.temperature.day,
            weatherCondition = dto.weather.firstOrNull()?.description.orEmpty()
        )
    }

    fun mapEntityToDomain(entity: WeatherEntity): Weather = Weather(
        id = entity.id ?: 0,
        dt = entity.dt,
        sunrise = entity.sunrise,
        sunset = entity.sunset,
        pressure = entity.pressure,
        humidity = entity.humidity,
        speed = entity.speed,
        deg = entity.deg,
        gust = entity.gust,
        clouds = entity.clouds,
        pop = entity.pop,
        minTemperature = entity.minTemperature,
        maxTemperature = entity.maxTemperature,
        dayTemperature = entity.dayTemperature,
        weatherCondition = entity.weatherCondition
    )

}