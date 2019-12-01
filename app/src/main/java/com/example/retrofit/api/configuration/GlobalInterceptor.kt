package com.example.retrofit.api.configuration

import com.example.retrofit.api.AUTH_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class GlobalInterceptor(private val addAuthorizationHeader: Boolean) : Interceptor {

    companion object {
        fun getOKHttpClientBuilded(addAuthorizationHeader: Boolean) = OkHttpClient.Builder().addInterceptor(GlobalInterceptor(addAuthorizationHeader)).build()
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain
            .request()
            .newBuilder()
            .addHeader("cache-control", "no-cache")
            .addHeader("Content-Type", "application/json")
        if (addAuthorizationHeader) requestBuilder.addHeader("Authorization", AUTH_KEY)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
