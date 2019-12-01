package com.example.retrofit.api.configuration

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class GlobalInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val authKey = "j6iiOLY8Vm8oLno5yn8R38jHxwm1QNou"
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", authKey)
            .addHeader("cache-control", "no-cache")
            .addHeader("Content-Type", "application/json")
            .build()
        val response = chain.proceed(request)
        return response
    }
}
