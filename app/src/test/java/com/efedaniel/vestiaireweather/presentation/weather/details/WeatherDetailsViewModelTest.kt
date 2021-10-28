package com.efedaniel.vestiaireweather.presentation.weather.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.efedaniel.vestiaireweather.domain.models.Weather
import com.efedaniel.vestiaireweather.domain.repositories.WeatherRepository
import com.efedaniel.vestiaireweather.presentation.common.extensions.EMPTY
import com.efedaniel.vestiaireweather.presentation.common.extensions.ZERO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class WeatherDetailsViewModelTest {

    companion object {
        val WEATHER = Weather(
            Long.ZERO,
            Long.ZERO,
            Long.ZERO,
            Long.ZERO,
            Long.ZERO,
            Long.ZERO,
            Double.ZERO,
            Long.ZERO,
            Double.ZERO,
            Long.ZERO,
            Double.ZERO,
            Double.ZERO,
            Double.ZERO,
            Double.ZERO,
            String.EMPTY
        )
    }

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: WeatherRepository

    private lateinit var viewModel: WeatherDetailsViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `should get weather from Database when weather id is set`() {
        runBlockingTest {
            // Given
            val mockObserver: Observer<Weather> = mock()
            whenever(repository.getWeatherByID(any())).thenReturn(WEATHER)

            // when
            viewModel = WeatherDetailsViewModel(repository)
            viewModel.setWeatherId(1L)
            viewModel.weather.observeForever(mockObserver)

            // Then
            verify(mockObserver).onChanged(WEATHER)
            verifyNoMoreInteractions(mockObserver)
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}