package com.cct.cleanarchitecturedemo.domain.usecases

import com.cct.cleanarchitecturedemo.data.remote.model.Blog
import com.cct.cleanarchitecturedemo.domain.models.BlogEntity
import com.cct.cleanarchitecturedemo.domain.repository.BlogRepository
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(private val blogRepository: BlogRepository) {
    suspend fun invoke(): List<BlogEntity> =
        blogRepository.getBlogs()?.let { it.mapToGetBlogs() }?: listOf()

}

fun List<Blog>.mapToGetBlogs(): List<BlogEntity> =
    this.map { blog ->
        BlogEntity(blog.id, blog.title, blog.body, blog.image, blog.category)
    }

