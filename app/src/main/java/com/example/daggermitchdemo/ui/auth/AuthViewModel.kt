package com.example.daggermitchdemo.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
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

    init {
        Log.d("AuthViewModel", "Complex Setup for multibinding Done")

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
        }.map(object : Function<User, AuthResource<User>> {
            override fun apply(t: User?): AuthResource<User> {
                if (t?.id == -1) {
                    return AuthResource.Error("Error on retriving user", null)
                }
                return AuthResource.AUTHENTICATED(t!!)
            }

        }).subscribeOn(Schedulers.io()))
    }
}