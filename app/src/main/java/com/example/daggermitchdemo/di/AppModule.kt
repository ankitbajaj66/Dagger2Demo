package com.example.daggermitchdemo.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */

@Module
class AppModule {
    @Module
    companion object {

        @Singleton
        @JvmStatic
        @Provides
        fun providesRetrofit(): Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        @Singleton
        @JvmStatic
        @Provides
        fun requestOptions() =
            RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)

        @Singleton
        @JvmStatic
        @Provides
        fun requestManager(application: Application, requestOptions: RequestOptions) =
            Glide.with(application).setDefaultRequestOptions(requestOptions)

        @Singleton
        @JvmStatic
        @Provides
        fun provideDrawable(application: Application): Drawable? =
            ContextCompat.getDrawable(application, R.drawable.logo)
    }
}