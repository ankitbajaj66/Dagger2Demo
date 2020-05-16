package com.example.daggermitchdemo.di

import android.app.Application
import com.example.daggermitchdemo.app.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

import dagger.android.support.AndroidSupportInjectionModule

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}