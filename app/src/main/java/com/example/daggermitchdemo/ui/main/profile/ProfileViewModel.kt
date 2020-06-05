package com.example.daggermitchdemo.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.ui.auth.AuthResource
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class ProfileViewModel @Inject constructor(private val sessionManager: SessionManager) :
    ViewModel() {

    init {
        Log.d("ProfileViewModel", "Welcome to ProfileViewModel")
    }

    fun getAuthenticatedUser() = sessionManager.getAuthUser()
}