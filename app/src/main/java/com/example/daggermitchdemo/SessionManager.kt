package com.example.daggermitchdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
@Singleton
class SessionManager @Inject constructor() {
    private val cachedUser = MediatorLiveData<AuthResource<User>>();

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        cachedUser.value = AuthResource.Loading()
        cachedUser.addSource(source) {
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun getAuthUser() : LiveData<AuthResource<User>> = cachedUser

    fun logout() {
        Log.d("MySessionManager", "logged out...")
        cachedUser.value = AuthResource.NOTAUTHENTICATED()
    }
}