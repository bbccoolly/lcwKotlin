package com.lcw.kt.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lcw.kt.api.unsplash.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
class UnsplashRepository @Inject constructor(private val service: UnsplashService) {

    fun getSearchResultStream(query: String): Flow<PagingData<UnsplashPhoto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { UnsplashPagingSource(service, query) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }
}
