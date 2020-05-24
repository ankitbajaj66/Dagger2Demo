package com.example.daggermitchdemo.network.auth

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 *Created by Ankit Bajaj on 18-05-2020.
 */
interface AuthApi {

    @GET
    fun getFakeStuff() : Call<ResponseBody>
}