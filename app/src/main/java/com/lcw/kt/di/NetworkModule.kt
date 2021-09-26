package com.lcw.kt.di

import com.lcw.kt.api.AuthInterceptor
import com.lcw.kt.api.LcwService
import com.lcw.kt.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Singleton
    @Provides
    fun provideGsonGsonConverterFactory(
        converterFactory: GsonConverterFactory
    ) = provideService(
        converterFactory, LcwService::
        class.java
    )

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    private fun createRetrofit(
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(LcwService.BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }).build())
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        converterFactory: GsonConverterFactory, clazz: Class<T>
    ): T {
        return createRetrofit(converterFactory).create(clazz)
    }

}