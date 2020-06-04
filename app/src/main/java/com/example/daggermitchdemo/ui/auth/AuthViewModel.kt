package com.example.daggermitchdemo.ui.auth

import android.util.Log
import androidx.lifecycle.*
import com.example.daggermitchdemo.models.User

import com.example.daggermitchdemo.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val authUser = MediatorLiveData<User>();

    init {
        Log.d("AuthViewModel", "Complex Setup for multibinding Done")

        if (this.authApi == null) {
            Log.d("AuthViewModel", "AuthApi Null")
        } else {
            Log.d("AuthViewModel", "AuthApi Not Null")
        }

        /*authApi.getUser(1).subscribeOn(Schedulers.io()).toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<User> {
                override fun onSubscribe(d: Disposable?) {
                    //
                }

                override fun onNext(value: User?) {
                    Log.d("AuthViewModel", "AuthApi Email ------ ${value?.email}")
                }

                override fun onError(e: Throwable?) {
                    //
                }

                override fun onComplete() {
                    //
                }
            })

    }*/


    }

    fun getAuthUser(): LiveData<User> = authUser

    fun authenticateUsingId(id: Int) {
        val source: LiveData<User> =
            LiveDataReactiveStreams.fromPublisher(authApi.getUser(id).subscribeOn(Schedulers.io()))

        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }
}