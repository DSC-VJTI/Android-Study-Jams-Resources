package com.example.myapplication.retrofitcode

import com.squareup.moshi.Json

class Post {
    @Json(name = "userId")
    var userId: Int? = null

    @Json(name = "id")
    var id: Int? = null

    @Json(name = "title")
    var title: String? = null

    @Json(name = "body")
    var body: String? = null

}
