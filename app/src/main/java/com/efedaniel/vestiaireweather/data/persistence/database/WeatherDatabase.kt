package com.efedaniel.vestiaireweather.data.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.efedaniel.vestiaireweather.data.persistence.database.daos.WeatherDao
import com.efedaniel.vestiaireweather.data.persistence.database.entities.WeatherEntity

@Database(
    entities = [
        WeatherEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao
}
