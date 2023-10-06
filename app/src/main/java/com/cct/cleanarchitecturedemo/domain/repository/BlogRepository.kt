package com.cct.cleanarchitecturedemo.domain.repository

import com.cct.cleanarchitecturedemo.data.remote.BlogService
import com.cct.cleanarchitecturedemo.data.remote.model.Blog
import javax.inject.Inject

interface BlogRepository {
    suspend fun getBlogs(): List<Blog>?

}

class BlogRepositoryImp @Inject constructor(private val blogService: BlogService) : BlogRepository {
    override suspend fun getBlogs(): List<Blog>? = blogService.getBlogs().body()
}

