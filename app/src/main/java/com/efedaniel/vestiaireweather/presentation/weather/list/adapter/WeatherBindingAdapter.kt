package com.efedaniel.vestiaireweather.presentation.weather.list.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.efedaniel.vestiaireweather.domain.models.Weather

/**
 * Helper method to submit a list of weathers to a recycler view adapter via Data Binding.
 */
@BindingAdapter("weatherList")
fun bindLiveLessonRecyclerView(recyclerView: RecyclerView, data: List<Weather>?) {
    data?.let { (recyclerView.adapter as WeatherListAdapter).submitList(data) }
}
