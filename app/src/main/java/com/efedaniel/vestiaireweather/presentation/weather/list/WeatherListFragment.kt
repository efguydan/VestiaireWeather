package com.efedaniel.vestiaireweather.presentation.weather.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.efedaniel.vestiaireweather.data.network.utils.LoadingStatus
import com.efedaniel.vestiaireweather.databinding.FragmentWeatherListBinding
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.presentation.base.BaseFragment
import com.efedaniel.vestiaireweather.presentation.common.extensions.hide
import com.efedaniel.vestiaireweather.presentation.common.extensions.invalidateElevation
import com.efedaniel.vestiaireweather.presentation.common.extensions.observeNonNull
import com.efedaniel.vestiaireweather.presentation.common.extensions.onScrollChanged
import com.efedaniel.vestiaireweather.presentation.common.extensions.show
import com.efedaniel.vestiaireweather.presentation.weather.list.adapter.WeatherListAdapter
import javax.inject.Inject

class WeatherListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: WeatherListViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentWeatherListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherListBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daggerAppComponent.inject(this)
        binding.viewModel = viewModel
        setupToolbar()

        initObservers()

        binding.weatherRecyclerView.adapter = WeatherListAdapter(::onWeatherClicked)
    }

    private fun initObservers() {
        viewModel.loadingStatus.observeNonNull(viewLifecycleOwner, ::onLoadingStatusUpdated)
    }

    private fun onLoadingStatusUpdated(loadingStatus: LoadingStatus) {
        when (loadingStatus) {
            is LoadingStatus.Loading -> binding.loadingContainer.rootView.show()
            is LoadingStatus.Success -> binding.loadingContainer.rootView.hide()
            is LoadingStatus.Error -> {
                binding.loadingContainer.rootView.hide()
                showSnackBar(binding.rootView, loadingStatus.errorMessage)
            }
        }
    }

    private fun onWeatherClicked(weather: Weather) {
        findNavController()
            .navigate(
                WeatherListFragmentDirections
                    .actionWeatherListFragmentToWeatherDetailsFragment(weather.id)
            )
    }

    private fun setupToolbar() {
        binding.weatherRecyclerView.onScrollChanged {
            binding.toolbarLayout.toolbarContainer.invalidateElevation(it)
        }
    }
}
