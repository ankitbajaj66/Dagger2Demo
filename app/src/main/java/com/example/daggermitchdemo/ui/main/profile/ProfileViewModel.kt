package com.example.daggermitchdemo.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.models.Post
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.network.main.PostApi
import com.example.daggermitchdemo.ui.auth.AuthResource
import com.example.daggermitchdemo.ui.main.Resource
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class ProfileViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val postApi: PostApi
) :
    ViewModel() {

    init {
        Log.d("ProfileViewModel", "Welcome to ProfileViewModel")
    }

    fun getAuthenticatedUser() = sessionManager.getAuthUser()
}