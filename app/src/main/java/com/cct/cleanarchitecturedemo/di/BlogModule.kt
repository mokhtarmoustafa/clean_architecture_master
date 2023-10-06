package com.cct.cleanarchitecturedemo.di

import com.cct.cleanarchitecturedemo.data.remote.BlogService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BlogModule {

    @Singleton
    @Provides
    fun provideOkHttp(okHttpClient: OkHttpClient): OkHttpClient = okHttpClient

    @Singleton
    @Provides
    fun provideGson(gson: Gson):Gson =gson
    @Singleton
    @Provides
    fun provideGsonConverterFactory( gson: Gson):GsonConverterFactory= GsonConverterFactory.create(gson)
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl("www.xyz.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit):BlogService =retrofit.create(BlogService::class.java)
}