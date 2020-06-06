package com.example.daggermitchdemo.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
class AuthViewModel @Inject constructor(
    private val authApi: AuthApi,
    private val sessionManager: SessionManager
) : ViewModel() {

    //    private val posts = MediatorLiveData<>
    init {
        Log.d("AuthViewModel", "Complex Setup for multi binding Done")

        if (this.authApi == null) {
            Log.d("AuthViewModel", "AuthApi Null")
        } else {
            Log.d("AuthViewModel", "AuthApi Not Null")
        }
    }

    fun observeAuthState(): LiveData<AuthResource<User>> = sessionManager.getAuthUser()

    fun authenticateUsingId(id: Int) {
        sessionManager.authenticateWithId(queryUserID(id))
    }

    private fun queryUserID(id: Int): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(authApi.getUser(id).onErrorReturn {
            val user = User()
            user.id = -1
            user
        }.map(Function<User, AuthResource<User>> { t ->
            if (t?.id == -1) {
                return@Function AuthResource.Error("Error on retriving user")
            }
            AuthResource.AUTHENTICATED(t!!)
        }).subscribeOn(Schedulers.io()))
    }
}