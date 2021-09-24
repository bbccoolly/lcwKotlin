package com.lcw.kt.api.lcw

import com.google.gson.annotations.SerializedName
import com.lcw.kt.api.unsplash.UnsplashPhoto

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
data class LcwEntity(
    @field:SerializedName("results") val results: List<UnsplashPhoto>,
    @field:SerializedName("total_pages") val totalPages: Int
)
