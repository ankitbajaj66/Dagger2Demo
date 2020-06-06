package com.example.daggermitchdemo.ui.main.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.models.Post
import kotlinx.android.synthetic.main.layout_post_list_item.view.*

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
class PostsRecyclerAdapter : RecyclerView.Adapter<PostsRecyclerAdapter.PostViewHolder>() {

    var posts : List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindData(posts[position])
    }


    class PostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val textViewTitle = itemView.title

        fun bindData(post: Post) {
            textViewTitle.text = post.title
        }
    }

    fun setPostList(posts1: List<Post>) {
        this.posts = posts1
        notifyDataSetChanged()
    }
}