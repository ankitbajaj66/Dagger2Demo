package com.example.daggermitchdemo.di

import com.example.daggermitchdemo.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesAuthActivity(): AuthActivity

//    @JvmStatic
//    @Provides
//    fun strData() = "hello"

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun someString(): String = "Hello Dagger"
    }

}