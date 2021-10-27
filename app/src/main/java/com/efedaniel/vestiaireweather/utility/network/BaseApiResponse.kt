package com.efedaniel.vestiaireweather.utility.network

import com.google.gson.annotations.SerializedName

class BaseApiResponse<T> {

    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("data")
    var data: T? = null
}
