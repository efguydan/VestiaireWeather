package com.efedaniel.vestiaireweather.presentation.weather.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.efedaniel.vestiaireweather.domain.models.Weather

object WeatherDiffCallback : DiffUtil.ItemCallback<Weather>() {
    override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem == newItem
    }
}