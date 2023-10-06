package com.cct.cleanarchitecturedemo.domain.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cct.cleanarchitecturedemo.data.cash.BlogDB
import retrofit2.http.DELETE

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blogDB: BlogDB):Long

    @Query("SELECT * FROM tbl_blog")
    suspend fun getBlogs():List<BlogDB>

    @Query("SELECT * FROM tbl_blog where id")
    suspend fun getBlog(blogId:Int):BlogDB

    @DELETE
    suspend fun deleteBlogs():Int
}