package com.cct.cleanarchitecturedemo.repository

import com.cct.cleanarchitecturedemo.data.cash.BlogDao
import com.cct.cleanarchitecturedemo.data.network.BlogService
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class BlogRepository (val dao:BlogDao,val service:BlogService) {



}