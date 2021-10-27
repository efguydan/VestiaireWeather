package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(

    @SerializedName("city")
    val city: CityDto,

    @SerializedName("cod")
    val code: Int,

    @SerializedName("message")
    val message: Double,

    @SerializedName("cnt")
    val count: Int,

    @SerializedName("list")
    val weathers: List<WeatherDto>

)