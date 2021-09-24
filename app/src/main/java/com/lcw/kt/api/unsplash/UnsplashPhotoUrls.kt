package com.lcw.kt.api.unsplash

import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
data class UnsplashPhotoUrls(
    @field:SerializedName("small") val small: String
)