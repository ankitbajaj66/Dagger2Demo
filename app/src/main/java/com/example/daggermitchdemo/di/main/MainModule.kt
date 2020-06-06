package com.example.daggermitchdemo.di.main

import com.example.daggermitchdemo.network.auth.AuthApi
import com.example.daggermitchdemo.network.main.PostApi
import com.example.daggermitchdemo.ui.main.posts.PostsRecyclerAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
@Module
class MainModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideAdaptor() = PostsRecyclerAdapter()


        @JvmStatic
        @Provides
        fun providesPostApi(retrofit: Retrofit): PostApi = retrofit.create(PostApi::class.java)
    }
}