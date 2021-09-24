package com.lcw.kt.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
@Entity(tableName = "photos")
data class PhotoImageEntity(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("urls")
    val urls: Urls,
    @field:SerializedName("user")
    val user: User
)

data class Urls(
    @field:SerializedName("small")
    val small: String,
)

data class User(
    @field:SerializedName("username")
    val username: String
)
