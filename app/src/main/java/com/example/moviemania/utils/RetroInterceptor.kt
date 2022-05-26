package com.example.moviemania.utils

import TOKEN
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class RetroInterceptor : Interceptor {
    //for api token interceptor
    //val newRequest = chain.request().newBuilder()
    //            .header("Authorization", "Bearer $TOKEN")
    //            .build()
    //
    //        return chain.proceed(newRequest)

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", TOKEN)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}