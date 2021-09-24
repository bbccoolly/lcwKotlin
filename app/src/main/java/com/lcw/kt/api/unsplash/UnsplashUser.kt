package com.lcw.kt.api.unsplash

import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
data class UnsplashUser(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("username") val username: String
) {
    val attributionUrl: String
        get() {
            return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
        }
}