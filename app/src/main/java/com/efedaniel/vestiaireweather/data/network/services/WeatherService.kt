package com.efedaniel.vestiaireweather.data.network.services

import com.efedaniel.vestiaireweather.data.network.dtos.WeatherResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("/data/2.5/forecast/daily")
    fun getWeatherForecast(
        @Query("q") city: String,
        @Query("mode") mode: String,
        @Query("units") units: String,
        @Query("cnt") cnt: String,
        @Query("appid") accessToken: String
    ): Response<WeatherResponseDto>

}