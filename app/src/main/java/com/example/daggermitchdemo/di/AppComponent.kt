package com.example.daggermitchdemo.di

import android.app.Application
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.app.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class, ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    fun sessionManager(): SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}