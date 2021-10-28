package com.efedaniel.vestiaireweather.data.persistence.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.efedaniel.vestiaireweather.utility.Constants

@Entity(tableName = Constants.DatabaseKeys.WEATHER_TABLE_NAME)
class WeatherEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,

    @ColumnInfo(name = "dt")
    val dt: Long,

    @ColumnInfo(name = "sunrise")
    val sunrise: Long,

    @ColumnInfo(name = "sunset")
    val sunset: Long,

    @ColumnInfo(name = "pressure")
    val pressure: Long,

    @ColumnInfo(name = "humidity")
    val humidity: Long,

    @ColumnInfo(name = "speed")
    val speed: Double,

    @ColumnInfo(name = "deg")
    val deg: Long,

    @ColumnInfo(name = "gust")
    val gust: Double,

    @ColumnInfo(name = "clouds")
    val clouds: Long,

    @ColumnInfo(name = "pop")
    val pop: Double,

    @ColumnInfo(name = "min_temperature")
    val minTemperature: Double,

    @ColumnInfo(name = "max_temperature")
    val maxTemperature: Double,

    @ColumnInfo(name = "day_temperature")
    val dayTemperature: Double,

    @ColumnInfo(name = "weatherCondition")
    val weatherCondition: String

)