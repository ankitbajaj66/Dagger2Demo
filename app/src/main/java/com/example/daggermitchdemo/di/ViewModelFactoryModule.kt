package com.example.daggermitchdemo.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggermitchdemo.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}