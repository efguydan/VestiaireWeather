package com.efedaniel.vestiaireweather.domain.models

data class Weather(
    val id: Long,
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val pressure: Long,
    val humidity: Long,
    val speed: Double,
    val deg: Long,
    val gust: Double,
    val clouds: Long,
    val pop: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val dayTemperature: Double,
    val weatherCondition: String
)