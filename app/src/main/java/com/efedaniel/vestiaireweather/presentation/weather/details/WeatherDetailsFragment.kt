package com.efedaniel.vestiaireweather.presentation.weather.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.efedaniel.vestiaireweather.R
import com.efedaniel.vestiaireweather.databinding.FragmentWeatherDetailsBinding
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.presentation.base.BaseFragment
import com.efedaniel.vestiaireweather.presentation.common.extensions.invalidateElevation
import com.efedaniel.vestiaireweather.presentation.common.extensions.observeNonNull
import com.efedaniel.vestiaireweather.presentation.common.extensions.onScrollChanged
import com.efedaniel.vestiaireweather.utility.date.LONG_DATE_FORMAT
import com.efedaniel.vestiaireweather.utility.date.convertToDateString
import com.efedaniel.vestiaireweather.utility.date.getDayOfWeek
import javax.inject.Inject

class WeatherDetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: WeatherDetailsViewModel by viewModels { viewModelFactory }
    private val args: WeatherDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentWeatherDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daggerAppComponent.inject(this)
        setupToolbar()

        viewModel.setWeatherId(args.weatherID)
        initObservers()
    }

    private fun initObservers() {
        viewModel.weather.observeNonNull(viewLifecycleOwner, ::onWeatherUpdated)
    }

    private fun onWeatherUpdated(weather: Weather) = binding.run {
        dayTextView.text = weather.dt.times(1000).getDayOfWeek()
        dateTextView.text = weather.dt.times(1000).convertToDateString(LONG_DATE_FORMAT)
        avgTemperatureTextView.text = "${weather.dayTemperature}℃"
        weatherConditionTextView.text = weather.weatherCondition
        temperatureDescriptionTextView.text = when (weather.dayTemperature) {
            in Double.MIN_VALUE..10.0 -> getString(R.string.cold)
            in 10.0..25.0 -> getString(R.string.normal)
            else -> getString(R.string.hot)
        }
        minTemperatureCardView.setMetricValue("${weather.minTemperature}℃")
        maxTemperatureCardView.setMetricValue("${weather.maxTemperature}℃")
        windSpeedCardView.setMetricValue("${weather.speed}mph")
        airPressureCardView.setMetricValue("${weather.pressure}hPa")
        humidityCardView.setMetricValue("${weather.humidity}%")
        cloudsCardView.setMetricValue("${weather.clouds}%")
        gustCardView.setMetricValue("${weather.gust}mps")
        popCardView.setMetricValue(weather.pop.toString())
    }

    private fun setupToolbar() {
        binding.scrollView.onScrollChanged {
            binding.toolbarLayout.toolbarContainer.invalidateElevation(it)
        }
    }
}
