package com.efedaniel.vestiaireweather.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(LiveViewModel::class)
//    abstract fun bindLiveViewModel(viewModel: LiveViewModel): ViewModel

}
