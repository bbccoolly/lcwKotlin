package com.lcw.kt.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
@Entity(tableName = "photos")
data class PhotoImageEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "urls")
    val urls: Urls,
    @ColumnInfo(name = "user")
    val user: User
)

data class Urls(
    @ColumnInfo(name = "small")
    val small: String,
)

data class User(
    @ColumnInfo(name = "username")
    val username: String
)
