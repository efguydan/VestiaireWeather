package com.efedaniel.vestiaireweather.di

import android.app.Application
import androidx.room.Room
import com.efedaniel.vestiaireweather.data.persistence.database.WeatherDatabase
import com.efedaniel.vestiaireweather.data.persistence.database.daos.WeatherDao
import com.efedaniel.vestiaireweather.utility.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

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
