package com.lcw.kt.test

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
data class Test2(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)

data class Result(
    val id: String,
    val urls: UrlsX,
    val user: UserX,
)


data class UrlsX(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class UserX(
    val username: String
)
