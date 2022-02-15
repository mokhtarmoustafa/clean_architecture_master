package com.cct.cleanarchitecturedemo.di

import com.cct.cleanarchitecturedemo.data.cash.BlogDao
import com.cct.cleanarchitecturedemo.data.network.BlogService
import com.cct.cleanarchitecturedemo.repository.BlogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(dao: BlogDao, service: BlogService): BlogRepository {

        return BlogRepository(dao, service)
    }
}