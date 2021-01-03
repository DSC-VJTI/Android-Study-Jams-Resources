package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentOddScreenBinding
import com.example.myapplication.databinding.FragmentRetrofitBinding
import com.example.myapplication.retrofitcode.PlaceholderAPI
import com.example.myapplication.retrofitcode.Post
import com.example.myapplication.retrofitcode.PostAdapter
import com.example.myapplication.retrofitcode.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [RetrofitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RetrofitFragment : Fragment() {
    private var posts: List<Post> = listOf()
    private lateinit var textView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRetrofitBinding>(inflater, R.layout.fragment_retrofit, container, false)

        recyclerView = binding.recyclerView
        textView = binding.textView

        recyclerView.layoutManager = LinearLayoutManager(this.activity)
        getAllPosts(recyclerView)
        getOnePost()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getAllPosts(recyclerView: RecyclerView) {
        val postList = PlaceholderAPI.buildService(PostService::class.java).getPostList()
        postList.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Log.e("Post List Error", "${t?.message}")
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                posts = response?.body()!!
                Log.i("PostSuccess", "$posts")

                textView.visibility = TextView.GONE

                val adapter = PostAdapter(posts) { post: Post ->
                    Toast.makeText(activity, post.title, Toast.LENGTH_SHORT).show()
                }
                recyclerView.adapter = adapter
            }

        })
    }

    private fun getOnePost() {
        val onePost = PlaceholderAPI.buildService(PostService::class.java).getPostWithId("1")
        onePost.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                Log.e("Data Failure", "${t?.message}")
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                val post = response?.body()
                Log.i("UserId", "${post?.userId}")
                Log.i("Id", "${post?.id}")
                Log.i("Title", "${post?.title}")
                Log.i("Body", "${post?.body}")
            }

        })
    }
}