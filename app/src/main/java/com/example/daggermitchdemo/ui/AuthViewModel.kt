package com.example.daggermitchdemo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
class AuthViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d("AuthViewModel", "Ankit Complex Setup Done")
    }
}