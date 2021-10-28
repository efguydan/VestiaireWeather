package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(

    @SerializedName("cod")
    val code: Int,

    @SerializedName("message")
    val message: Double,

    @SerializedName("list")
    val weathers: List<WeatherDto>

)