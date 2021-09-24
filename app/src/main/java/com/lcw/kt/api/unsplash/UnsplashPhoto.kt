package com.lcw.kt.api.unsplash

import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
data class UnsplashPhoto(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("urls") val urls: UnsplashPhotoUrls,
    @field:SerializedName("user") val user: UnsplashUser
)
