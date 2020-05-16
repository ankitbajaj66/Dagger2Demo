package com.example.daggermitchdemo.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daggermitchdemo.R
import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 16-05-2020.
 */
@Module
class AppModule {
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun requestOptions() =
            RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)

        @JvmStatic
        @Provides
        fun requestManager(application: Application, requestOptions: RequestOptions) =
            Glide.with(application).setDefaultRequestOptions(requestOptions)

        @JvmStatic
        @Provides
        fun provideDrawable(application: Application) :Drawable? =
            ContextCompat.getDrawable(application, R.drawable.logo)
    }
}