package com.efedaniel.vestiaireweather.presentation.weather.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.efedaniel.vestiaireweather.R
import com.efedaniel.vestiaireweather.databinding.FragmentWeatherListBinding
import com.efedaniel.vestiaireweather.presentation.base.BaseFragment

class WeatherListFragment : BaseFragment() {

    private lateinit var binding: FragmentWeatherListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherListBinding.inflate(layoutInflater)
        return binding.root
    }

}