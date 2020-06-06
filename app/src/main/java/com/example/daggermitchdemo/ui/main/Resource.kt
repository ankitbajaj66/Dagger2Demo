package com.example.daggermitchdemo.ui.main

import com.example.daggermitchdemo.ui.auth.AuthResource

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}