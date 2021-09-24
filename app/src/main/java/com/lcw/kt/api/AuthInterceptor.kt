package com.lcw.kt.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
class AuthInterceptor(private val accessToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "Authorization", "key $accessToken").build()
        return chain.proceed(request)
    }
}
