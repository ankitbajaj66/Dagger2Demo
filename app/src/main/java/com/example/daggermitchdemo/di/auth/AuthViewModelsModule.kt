package com.example.daggermitchdemo.di.auth

import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.di.ViewModelKey
import com.example.daggermitchdemo.ui.auth.AuthViewModel
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
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}