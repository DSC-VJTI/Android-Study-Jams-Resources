package com.example.myapplication.retrofitcode

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class PlaceholderAPI {

    companion object{
        private val url = "https://jsonplaceholder.typicode.com/"
        val postService: PostService? = null

        private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
    }
}

interface PostService {
    @GET("posts")
    fun getPostList(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getPostWithId(@Path("postId") id: String): Call<Post>
}