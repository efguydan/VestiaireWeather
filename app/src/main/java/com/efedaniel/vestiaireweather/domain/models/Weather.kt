package com.efedaniel.vestiaireweather.domain.models

data class Weather(
    val id: Long,
    val dt: Long,
    val pressure: Long,
    val humidity: Long,
    val speed: Double,
    val temperature: Double
)