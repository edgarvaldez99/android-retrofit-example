package com.example.retrofit.api.configuration

import com.example.retrofit.api.BASE_URL
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofitBuilder(mapper: Gson, addAuthorizationHeader: Boolean = false): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(mapper))
    .addCallAdapterFactory(LiveDataCallAdapterFactory())
    .client(GlobalInterceptor.getOKHttpClientBuilded(addAuthorizationHeader))
    .build()