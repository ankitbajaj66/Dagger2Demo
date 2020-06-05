package com.example.daggermitchdemo.ui.main.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.network.main.PostApi
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
class PostsViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val postApi: PostApi
) : ViewModel() {
    init {
        Log.d("PostsViewModel", "Welcome to PostsViewModel")
    }
}