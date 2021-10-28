package com.efedaniel.vestiaireweather.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.efedaniel.vestiaireweather.data.network.utils.LoadingStatus
import com.efedaniel.vestiaireweather.presentation.common.livedata.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    protected val _loadingStatus = SingleLiveEvent<LoadingStatus>()

    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus
}
