package com.cct.cleanarchitecturedemo.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cct.cleanarchitecturedemo.domain.models.BlogDao
import com.cct.cleanarchitecturedemo.domain.models.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object BlogDBModule {


    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): BlogDatabase =
        Room.databaseBuilder(
            context = applicationContext,
            BlogDatabase::class.java,
            "blogs.db"
        ).build()


    @Singleton
    @Provides
    fun provideDao(blogDatabase: BlogDatabase):BlogDao = blogDatabase.getDao()
}