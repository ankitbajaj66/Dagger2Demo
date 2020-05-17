package com.example.daggermitchdemo.di

import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.ui.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindViewModel(authViewModel: AuthViewModel): ViewModel
}