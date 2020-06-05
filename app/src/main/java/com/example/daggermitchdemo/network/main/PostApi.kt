package com.example.daggermitchdemo.network.main

import com.example.daggermitchdemo.models.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
interface PostApi {

    @GET("posts")
    fun getPosts(@Query("userId") userID: Int): Flowable<List<Post>>
}