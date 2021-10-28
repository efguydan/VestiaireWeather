package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class WeatherDto(

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
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
    val gust: Double,

    @SerializedName("clouds")
    val clouds: Long,

    @SerializedName("pop")
    val pop: Double,

    @SerializedName("temp")
    val temperature: TemperatureDto,

    @SerializedName("feels_like")
    val feelsLike: FeelsLikeDto,

    @SerializedName("weather")
    val weather: List<WeatherConditionDto>

)