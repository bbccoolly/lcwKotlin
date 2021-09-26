package com.lcw.kt.api

import com.lcw.kt.BuildConfig
import com.lcw.kt.api.lcw.ResultsResponse
import com.lcw.kt.room.PhotoImageEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
interface LcwService {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_ACCESS_KEY
    ): Response<ResultsResponse<PhotoImageEntity>>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}