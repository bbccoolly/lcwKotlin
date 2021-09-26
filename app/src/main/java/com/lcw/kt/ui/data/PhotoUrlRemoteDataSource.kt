package com.lcw.kt.ui.data

import com.lcw.kt.BuildConfig
import com.lcw.kt.api.BaseDataSource
import com.lcw.kt.api.LcwService
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/26
 */
class PhotoUrlRemoteDataSource @Inject constructor(private val service: LcwService) :
    BaseDataSource() {

    suspend fun fetchData() = getResult {
        service.searchPhotos("美女",1,25, BuildConfig.UNSPLASH_ACCESS_KEY)
    }
}