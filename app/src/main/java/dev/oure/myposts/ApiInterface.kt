package dev.oure.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
    
    @GET("/posts/{id}")
    fun gerPostById(@Path("id") PostId: Int): Call<Post>
}