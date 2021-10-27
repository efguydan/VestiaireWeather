package com.efedaniel.vestiaireweather.di

import com.efedaniel.vestiaireweather.BuildConfig
import com.efedaniel.vestiaireweather.data.network.services.WeatherService
import com.efedaniel.vestiaireweather.utility.Constants
import com.google.gson.Gson
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [LocalDataModule::class])
class APIServiceModule {

    @Provides
    @Singleton
    fun providesWeatherService(
        client: Lazy<OkHttpClient>,
        gsonConverter: GsonConverterFactory
    ): WeatherService {
        return Retrofit.Builder()
            .baseUrl(Constants.Variables.BASE_URL)
            .client(client.get())
            .addConverterFactory(gsonConverter)
            .build()
            .create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

}