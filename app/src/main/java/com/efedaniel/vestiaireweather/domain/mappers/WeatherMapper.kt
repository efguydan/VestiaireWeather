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
            pressure = dto.pressure,
            humidity = dto.humidity,
            speed = dto.speed,
            temperature = dto.feelsLike.day
        )
    }

    fun mapEntityToDomain(entity: WeatherEntity): Weather = Weather(
        id = entity.id ?: 0,
        dt = entity.dt,
        pressure = entity.pressure,
        humidity = entity.humidity,
        speed = entity.speed,
        temperature = entity.temperature
    )

}