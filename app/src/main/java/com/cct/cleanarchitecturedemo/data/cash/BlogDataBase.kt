package com.cct.cleanarchitecturedemo.data.cash

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cct.cleanarchitecturedemo.model.Blog
import javax.inject.Singleton


@Database(entities = ([Blog::class]), version = 1)
abstract class BlogDataBase:RoomDatabase() {
    abstract  fun getDao():BlogDao

    companion object{
        const val DATABASE_NAME="blog.db"
    }
}