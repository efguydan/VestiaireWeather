package com.efedaniel.vestiaireweather.presentation.weather.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.efedaniel.vestiaireweather.R
import com.efedaniel.vestiaireweather.databinding.ItemWeatherListBinding
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.presentation.common.extensions.inflate
import com.efedaniel.vestiaireweather.utility.date.convertToDateString

class WeatherListAdapter(
    private val onWeatherClicked: (Weather) -> Unit
): ListAdapter<Weather, WeatherListAdapter.ViewHolder>(WeatherDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWeatherListBinding.bind(parent.inflate(R.layout.item_weather_list)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemWeatherListBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Weather) = binding.run {
            // I didn't understand the date format in the dto. Hence displaying a placeholder here.
            dayTextView.text = "Tuesday"
            dateTextView.text = item.dt.convertToDateString()

            conditionTextView.text = item.weatherCondition
            temperatureTextView.text = "${item.dayTemperature}℃"
            windSpeedTextView.text = "${item.speed}mph"
            airPressureTextView.text = "${item.pressure}"
            humidityTextView.text = "${item.humidity}%"
        }

    }

}

