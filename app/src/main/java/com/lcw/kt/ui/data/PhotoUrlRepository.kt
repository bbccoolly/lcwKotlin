package com.lcw.kt.ui.data

import com.lcw.kt.data.resultLiveData
import com.lcw.kt.room.PhotoImageDao
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/26
 */
class PhotoUrlRepository @Inject constructor(
    private val dao: PhotoImageDao,
    private val remoteDataSource: PhotoUrlRemoteDataSource
) {
    val urlsData = resultLiveData(
        databaseQuery = { dao.getAll() },
        networkCall = { remoteDataSource.fetchData() },
        saveCallResult = { dao.insertAll(it.results) }
    )
}