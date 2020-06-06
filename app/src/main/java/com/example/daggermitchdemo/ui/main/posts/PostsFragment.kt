package com.example.daggermitchdemo.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.ui.main.Resource
import com.example.daggermitchdemo.utils.VerticalSpaceItemDecorator
import com.example.daggermitchdemo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
class PostsFragment : DaggerFragment() {

    private lateinit var postsViewModel: PostsViewModel

    @Inject
    lateinit var postsRecyclerAdapter: PostsRecyclerAdapter

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "Posts Fragment", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postsViewModel = ViewModelProvider(this, providerFactory).get(PostsViewModel::class.java)

        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        postsViewModel.observePostState().removeObservers(viewLifecycleOwner)
        postsViewModel.observePostState().observe(viewLifecycleOwner, Observer {

                resource ->
            when (resource) {
                is Resource.Success -> {Log.d(
                    "PostsFragment",
                    "PostsFragment data ${resource.data?.size}"
                )
                postsRecyclerAdapter.setPostList(resource.data!!)
                }
                is Resource.Error -> Log.d(
                    "PostsFragment",
                    "PostsFragment Error ${resource.message}"
                )
            }
        })
    }

    private fun initRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        val verticalSpaceItemDecorator = VerticalSpaceItemDecorator(15)
        recycler_view.addItemDecoration(verticalSpaceItemDecorator)
        recycler_view.adapter = postsRecyclerAdapter

    }
}