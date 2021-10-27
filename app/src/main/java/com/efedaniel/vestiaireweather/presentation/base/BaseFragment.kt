package com.efedaniel.vestiaireweather.presentation.base

import androidx.fragment.app.Fragment
import com.efedaniel.vestiaireweather.MainActivity

abstract class BaseFragment : Fragment() {

    protected val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
        }

//    protected val daggerAppComponent: AppComponent
//        get() = (mainActivity.applicationContext as App).component
}
