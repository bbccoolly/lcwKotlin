package com.lcw.kt.api.unsplash

import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
data class UnsplashSearchResponse(
    @field:SerializedName("results") val results: List<UnsplashPhoto>,
    @field:SerializedName("total_pages") val totalPages: Int
)
