package com.efedaniel.vestiaireweather.data.network.services

import com.efedaniel.vestiaireweather.BuildConfig
import com.efedaniel.vestiaireweather.data.network.dtos.WeatherResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("/data/2.5/forecast/daily")
    suspend fun getWeatherForecast(
        @Query("q") city: String = "Paris",
        @Query("mode") mode: String = "json",
        @Query("units") units: String = "metric",
        @Query("cnt") cnt: String = "16",
        @Query("appid") accessToken: String = BuildConfig.API_KEY
    ): Response<WeatherResponseDto>

}