package com.cct.cleanarchitecturedemo.repository

import com.cct.cleanarchitecturedemo.data.cash.BlogDao
import com.cct.cleanarchitecturedemo.data.network.BlogService
import com.cct.cleanarchitecturedemo.model.Blog
import com.cct.cleanarchitecturedemo.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BlogRepository(private val dao: BlogDao, private val service: BlogService) {

    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        try {
            emit(DataState.Loading)
            val networkBlogs = service.getPlugs()
            networkBlogs.forEach {
                dao.insertBlog(it)
            }
            emit(DataState.Success(dao.getBlogs()))
        } catch (ex: Exception) {
            emit(DataState.Error(ex.message!!))
        }
    }
}