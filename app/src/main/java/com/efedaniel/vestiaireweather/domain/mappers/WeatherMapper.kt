package com.efedaniel.vestiaireweather.domain.mappers

import com.efedaniel.vestiaireweather.data.network.dtos.WeatherDto
import com.efedaniel.vestiaireweather.data.persistence.entities.WeatherEntity
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
            deg = dto.deg
        )
    }

    fun mapEntityToDomain(entity: WeatherEntity): Weather = Weather(
        id = entity.id ?: 0,
        dt = entity.dt,
        pressure = entity.pressure,
        humidity = entity.humidity,
        speed = entity.speed,
        deg = entity.deg
    )

}