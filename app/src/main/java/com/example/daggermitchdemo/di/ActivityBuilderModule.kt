package com.example.daggermitchdemo.di

import com.example.daggermitchdemo.ui.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
    abstract fun contributesAuthActivity(): AuthActivity

}