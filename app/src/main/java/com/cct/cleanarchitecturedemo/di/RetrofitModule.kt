package com.cct.cleanarchitecturedemo.di

import com.cct.cleanarchitecturedemo.data.network.BlogService
import com.cct.cleanarchitecturedemo.util.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.nio.file.attribute.AclEntry.newBuilder
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson().newBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): BlogService {
        return retrofit.newBuilder().build().create(BlogService::class.java)
    }
}