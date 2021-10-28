package com.efedaniel.vestiaireweather.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.efedaniel.vestiaireweather.presentation.common.livedata.SingleLiveEvent
import com.efedaniel.vestiaireweather.utility.network.LoadingStatus

abstract class BaseViewModel : ViewModel() {

    protected val _loadingStatus = SingleLiveEvent<LoadingStatus>()

    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus

}
