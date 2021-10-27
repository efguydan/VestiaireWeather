package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class CityDto(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("population")
    val population: Long,

    @SerializedName("timezone")
    val timezone: Long

)