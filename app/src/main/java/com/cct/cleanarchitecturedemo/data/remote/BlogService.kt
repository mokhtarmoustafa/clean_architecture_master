package com.cct.cleanarchitecturedemo.data.remote

import com.cct.cleanarchitecturedemo.data.remote.model.Blog
import retrofit2.Response
import retrofit2.http.GET

interface BlogService {

    @GET("/blogs")
    suspend fun getBlogs(): Response<List<Blog>>

}