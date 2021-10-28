package com.efedaniel.vestiaireweather.presentation.base

import android.view.View
import androidx.fragment.app.Fragment
import com.efedaniel.vestiaireweather.MainActivity
import com.efedaniel.vestiaireweather.VestiaireWeatherApp
import com.efedaniel.vestiaireweather.di.AppComponent
import com.google.android.material.snackbar.Snackbar

/**
 * A base class for Fragments to do some basic setup
 */
abstract class BaseFragment : Fragment() {

    protected val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
        }

    protected val daggerAppComponent: AppComponent
        get() = (mainActivity.applicationContext as VestiaireWeatherApp).component

    fun showSnackBar(
        rootView: View,
        message: String
    ) {
        Snackbar
            .make(rootView, message, Snackbar.LENGTH_LONG)
            .show()
    }
}
