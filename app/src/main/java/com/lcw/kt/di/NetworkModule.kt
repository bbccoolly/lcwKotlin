package com.lcw.kt.di

import com.lcw.kt.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideUnsplashService(): UnsplashService {
        return UnsplashService.create()
    }
}