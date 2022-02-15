package com.cct.cleanarchitecturedemo.data.network

import com.cct.cleanarchitecturedemo.model.Blog
import retrofit2.http.GET
import javax.inject.Singleton


interface BlogService {
    @GET("blogs")
    suspend fun getPlugs():List<Blog>
}