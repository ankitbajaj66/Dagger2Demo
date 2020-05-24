package com.example.daggermitchdemo.di.auth

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.network.auth.AuthApi
import com.example.daggermitchdemo.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 18-05-2020.
 */
@Module
class AuthModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
    }
}