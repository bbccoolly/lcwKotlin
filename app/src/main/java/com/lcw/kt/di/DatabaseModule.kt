package com.lcw.kt.di

import android.content.Context
import com.lcw.kt.room.AppDatabase
import com.lcw.kt.room.PhotoImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * desc: TODO
 *
 *
 * create by lcz on 2021/9/23
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePhotoImageDao(appDatabase: AppDatabase): PhotoImageDao {
        return appDatabase.photoImageDao()
    }
}