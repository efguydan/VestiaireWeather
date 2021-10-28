package com.efedaniel.vestiaireweather.data.persistence.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efedaniel.vestiaireweather.data.persistence.database.entities.WeatherEntity
import com.efedaniel.vestiaireweather.utility.Constants.DatabaseKeys.WEATHER_TABLE_NAME

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weathers: List<WeatherEntity>)

    @Query("SELECT * FROM $WEATHER_TABLE_NAME")
    fun observeAllWeather(): LiveData<List<WeatherEntity>>

    @Query("SELECT * FROM $WEATHER_TABLE_NAME WHERE id = :id")
    suspend fun getWeatherByID(id: Long): WeatherEntity

    @Query("DELETE FROM $WEATHER_TABLE_NAME")
    suspend fun clearTable()
}
