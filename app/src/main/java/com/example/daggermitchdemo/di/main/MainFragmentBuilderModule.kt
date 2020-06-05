package com.example.daggermitchdemo.di.main

import com.example.daggermitchdemo.ui.main.posts.PostsFragment
import com.example.daggermitchdemo.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostsFragment() : PostsFragment
}