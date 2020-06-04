package com.example.daggermitchdemo.network.auth

import com.example.daggermitchdemo.models.User
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by Ankit Bajaj on 18-05-2020.
 */
interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>
}