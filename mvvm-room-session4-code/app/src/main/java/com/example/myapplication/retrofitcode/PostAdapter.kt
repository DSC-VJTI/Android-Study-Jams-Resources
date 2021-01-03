package com.example.myapplication.retrofitcode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class PostAdapter(private val posts: List<Post>, private val listener: (Post) -> Unit): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bindItem(post: Post){
            val title = view.findViewById<TextView>(R.id.username)
            val body = view.findViewById<TextView>(R.id.address)
            title.text = post.title
            body.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(posts[position])
        holder.itemView.setOnClickListener { listener(posts[position]) }
    }
}