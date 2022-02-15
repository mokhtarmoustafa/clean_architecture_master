package com.cct.cleanarchitecturedemo.data.network

import com.cct.cleanarchitecturedemo.model.Blog
import retrofit2.http.GET

interface BlogService {
    @GET("plogs")
    suspend fun getPlugs():List<Blog>
}