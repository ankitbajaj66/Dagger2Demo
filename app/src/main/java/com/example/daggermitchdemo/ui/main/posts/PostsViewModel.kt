package com.example.daggermitchdemo.ui.main.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.daggermitchdemo.SessionManager
import com.example.daggermitchdemo.models.Post
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.network.main.PostApi
import com.example.daggermitchdemo.ui.auth.AuthResource
import com.example.daggermitchdemo.ui.main.Resource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
class PostsViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val postApi: PostApi
) : ViewModel() {

    private val posts = MediatorLiveData<Resource<List<Post>>>()

    init {
        Log.d("PostsViewModel", "Welcome to PostsViewModel")
    }

    fun observePostState(): LiveData<Resource<List<Post>>> {
        posts.value = Resource.Loading()
        val source: LiveData<Resource<List<Post>>> =
            LiveDataReactiveStreams.fromPublisher(postApi.getPosts(sessionManager.getAuthUser().value?.data?.id!!).onErrorReturn {
                val post = Post()
                post.id = -1
                val list = ArrayList<Post>()
                list.add(post)
                list
            }.map(Function<List<Post>, Resource<List<Post>>> { t ->
                if (t == null) {
                    return@Function Resource.Error("Error Empty")
                } else {
                    if (t.isNotEmpty()) {
                        if (t.get(0).id == -1) {
                            return@Function Resource.Error("", null)
                        }
                    }
                }
                Resource.Success(t)
            }).subscribeOn(Schedulers.io()))

        posts.addSource(source, Observer {
            posts.value = it
            posts.removeSource(source)
        })
        return posts
    }


}