package com.efedaniel.vestiaireweather.data.network.dtos

import com.google.gson.annotations.SerializedName

data class FeelsLikeDto(

    @SerializedName("day")
    val day: Double,

    @SerializedName("night")
    val night: Double,

    @SerializedName("eve")
    val eve: Double,

    @SerializedName("morn")
    val morn: Double

)
