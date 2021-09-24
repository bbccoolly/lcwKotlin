package com.lcw.kt

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.lcw.kt.BuildConfig
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
@HiltAndroidApp
class LcwApp : Application(), Configuration.Provider {

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) Log.DEBUG else Log.ERROR).build()
    }
}