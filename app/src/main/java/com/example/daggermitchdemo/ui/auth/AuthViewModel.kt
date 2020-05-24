package com.example.daggermitchdemo.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.network.auth.AuthApi
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    init {
        Log.d("AuthViewModel", "Ankit Complex Setup Done")

        if (this.authApi == null) {
            Log.d("AuthViewModel", "AuthApi Null")
        } else {
            Log.d("AuthViewModel", "AuthApi Not Null")
        }
    }
}