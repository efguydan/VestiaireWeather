package com.efedaniel.vestiaireweather.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.efedaniel.vestiaireweather.data.persistence.database.WeatherDatabase
import com.efedaniel.vestiaireweather.data.persistence.database.daos.WeatherDao
import com.efedaniel.vestiaireweather.data.persistence.prefs.PrefsUtils
import com.efedaniel.vestiaireweather.utility.Constants
import com.efedaniel.vestiaireweather.utility.Constants.Variables.SHARED_PREFS_NAME
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun providesPrefsUtils(prefs: SharedPreferences, gson: Gson): PrefsUtils =
        PrefsUtils(prefs, gson)

    @Provides
    @Singleton
    fun providesGlobalSharedPreference(app: Application): SharedPreferences =
        app.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providesWeatherDatabase(app: Application): WeatherDatabase = Room.databaseBuilder(
        app,
        WeatherDatabase::class.java,
        Constants.DatabaseKeys.DATABASE_NAME
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    fun providesWeatherDao(db: WeatherDatabase): WeatherDao = db.getWeatherDao()
}
