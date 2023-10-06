package com.cct.cleanarchitecturedemo.domain.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cct.cleanarchitecturedemo.data.cash.BlogDB


@Database(entities = [BlogDB::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun getDao(): BlogDao
}