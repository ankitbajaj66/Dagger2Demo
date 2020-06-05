package com.example.daggermitchdemo.ui.auth

import com.bumptech.glide.load.engine.Resource

/**
 *Created by Ankit Bajaj on 04-06-2020.
 */
// A generic class that contains data and status about loading this data.
sealed class AuthResource<T>(val data: T? = null, val message: String? = null) {
    class AUTHENTICATED<T>(data: T) : AuthResource<T>(data)
    class NOTAUTHENTICATED<T>() : AuthResource<T>()
    class Loading<T>() : AuthResource<T>()
    class Error<T>(message: String, data: T? = null) : AuthResource<T>(data, message)
}