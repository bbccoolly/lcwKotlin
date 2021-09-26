package com.lcw.kt.api.lcw

import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
data class ResultsResponse<T>(
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int
)
