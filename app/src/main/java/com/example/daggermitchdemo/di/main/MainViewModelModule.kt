package com.example.daggermitchdemo.di.main

import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.di.ViewModelKey
import com.example.daggermitchdemo.ui.auth.AuthViewModel
import com.example.daggermitchdemo.ui.main.posts.PostsViewModel
import com.example.daggermitchdemo.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel
}