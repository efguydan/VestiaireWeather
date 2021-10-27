package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class WeatherDto(

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("dt")
    val sunrise: Long,

    @SerializedName("dt")
    val sunset: Long,

    @SerializedName("pressure")
    val pressure: Long,

    @SerializedName("humidity")
    val humidity: Long,

    @SerializedName("speed")
    val speed: Double,

    @SerializedName("deg")
    val deg: Long,

    @SerializedName("gust")
    val gust: Long,

    @SerializedName("clouds")
    val clouds: Long,

    @SerializedName("pop")
    val pop: Long,

    @SerializedName("temp")
    val temperature: TemperatureDto,

    @SerializedName("feels_like")
    val feelsLike: FeelsLikeDto,

    @SerializedName("weather")
    val weather: List<WeatherConditionDto>

)