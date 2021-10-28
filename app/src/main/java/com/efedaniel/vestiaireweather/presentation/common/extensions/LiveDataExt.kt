package com.efedaniel.vestiaireweather.presentation.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Helper method to observe a LiveData ensuring only non-null data are consumed
 */
inline fun <T> LiveData<T>.observeNonNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) = observe(owner, { it?.let { observer(it) } })
