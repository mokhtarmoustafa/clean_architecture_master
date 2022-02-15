package com.cct.cleanarchitecturedemo.data.cash

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cct.cleanarchitecturedemo.model.Blog

@Dao
interface BlogDao {
    @Query("SELECT * FROM tbl_blog")
    suspend fun getBlogs(): List<Blog>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blog: Blog)

}