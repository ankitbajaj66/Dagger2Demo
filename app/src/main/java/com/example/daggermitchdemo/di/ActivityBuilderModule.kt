package com.example.daggermitchdemo.di

import com.example.daggermitchdemo.di.auth.AuthModule
import com.example.daggermitchdemo.ui.auth.AuthActivity
import com.example.daggermitchdemo.di.auth.AuthViewModelsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class])
    abstract fun contributesAuthActivity(): AuthActivity

}