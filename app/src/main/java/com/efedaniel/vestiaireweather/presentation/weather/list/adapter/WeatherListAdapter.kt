package com.efedaniel.vestiaireweather.presentation.weather.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.efedaniel.vestiaireweather.R
import com.efedaniel.vestiaireweather.databinding.ItemWeatherListBinding
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.presentation.common.extensions.inflate
import com.efedaniel.vestiaireweather.utility.date.SHORT_DATE_FORMAT
import com.efedaniel.vestiaireweather.utility.date.convertToDateString
import com.efedaniel.vestiaireweather.utility.date.getDayOfWeek

class WeatherListAdapter(
    private val onWeatherClicked: (Weather) -> Unit
) : ListAdapter<Weather, WeatherListAdapter.ViewHolder>(WeatherDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWeatherListBinding.bind(parent.inflate(R.layout.item_weather_list)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemWeatherListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Weather) = binding.run {
            dayTextView.text = item.dt.times(1000).getDayOfWeek()
            dateTextView.text = item.dt.times(1000).convertToDateString(SHORT_DATE_FORMAT)

            conditionTextView.text = item.weatherCondition
            temperatureTextView.text = "${item.dayTemperature}℃"
            windSpeedTextView.text = "${item.speed}mph"
            airPressureTextView.text = item.pressure.toString()
            humidityTextView.text = "${item.humidity}%"

            rootView.setOnClickListener { onWeatherClicked(item) }
        }
    }
}
