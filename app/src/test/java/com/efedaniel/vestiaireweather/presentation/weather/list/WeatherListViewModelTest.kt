package com.efedaniel.vestiaireweather.presentation.weather.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.efedaniel.vestiaireweather.data.network.utils.GENERIC_ERROR_CODE
import com.efedaniel.vestiaireweather.data.network.utils.LoadingStatus
import com.efedaniel.vestiaireweather.data.network.utils.Result
import com.efedaniel.vestiaireweather.domain.repositories.WeatherRepository
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
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class WeatherListViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: WeatherRepository

    private lateinit var viewModel: WeatherListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `Should post loading status success when load weathers call is successful`() {
        runBlockingTest {
            // Given
            val mockObserver: Observer<LoadingStatus> = mock()
            val expectedResult = true
            whenever(repository.fetchWeatherForecast()).thenReturn(Result.Success(expectedResult))

            // when
            viewModel = WeatherListViewModel(repository)
            viewModel.loadingStatus.observeForever(mockObserver)

            // Then
            verify(mockObserver).onChanged(Mockito.isA(LoadingStatus.Success::class.java))
            verifyNoMoreInteractions(mockObserver)
        }
    }

    @Test
    fun `Should show offline results message when load weathers call is not successful`() {
        runBlockingTest {
            // Given
            val mockObserver: Observer<LoadingStatus> = mock()
            val expectedResult = "No Internet Connection. Displaying Cached Forecasts"
            whenever(repository.fetchWeatherForecast()).thenReturn(Result.Error(GENERIC_ERROR_CODE, expectedResult))

            // when
            viewModel = WeatherListViewModel(repository)
            viewModel.loadingStatus.observeForever(mockObserver)

            // Then
            verify(mockObserver).onChanged(LoadingStatus.Error(expectedResult))
            verifyNoMoreInteractions(mockObserver)
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
