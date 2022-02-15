package com.cct.cleanarchitecturedemo.di

import android.content.Context
import androidx.room.Room
import com.cct.cleanarchitecturedemo.data.cash.BlogDao
import com.cct.cleanarchitecturedemo.data.cash.BlogDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): BlogDataBase {
        return Room.databaseBuilder(context, BlogDataBase::class.java, BlogDataBase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideRoomService(roomDatabase: BlogDataBase): BlogDao {
        return roomDatabase.getDao()
    }
}