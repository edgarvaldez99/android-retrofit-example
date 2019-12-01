package com.example.retrofit.injection.module

import com.example.retrofit.api.AuthApiService
import com.example.retrofit.api.configuration.Deserializer
import com.example.retrofit.api.configuration.getRetrofitBuilder
import com.example.retrofit.data.User
import com.example.retrofit.executor.IOExecutors
import com.google.gson.GsonBuilder
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
        val mapper = GsonBuilder()
            .registerTypeAdapter(User::class.java, Deserializer<User>())
            .create()

        return getRetrofitBuilder(mapper, true).create(AuthApiService::class.java)
    }
}