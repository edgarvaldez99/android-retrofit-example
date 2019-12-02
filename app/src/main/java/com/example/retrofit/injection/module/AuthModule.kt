package com.example.retrofit.injection.module

import com.example.retrofit.api.AuthApiService
import com.example.retrofit.api.configuration.Deserializer
import com.example.retrofit.api.ResponseData
import com.example.retrofit.data.User
import com.example.retrofit.executor.IOExecutors
import com.example.retrofit.utils.getRetrofitBuilder
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthModule {

    @Singleton
    @Provides
    fun provideIOExecutors(): IOExecutors = IOExecutors()

    @Singleton
    @Provides
    fun provideAuthApiService(): AuthApiService {
        val type = object : TypeToken<ResponseData<User>>() {}.type
        val mapper = GsonBuilder()
            .registerTypeAdapter(type, Deserializer<ResponseData<User>>())
            .create()

        return getRetrofitBuilder(mapper, true).create(AuthApiService::class.java)
    }
}