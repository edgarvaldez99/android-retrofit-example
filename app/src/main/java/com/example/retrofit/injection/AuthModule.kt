package com.example.retrofit.injection

import com.example.retrofit.api.AuthApiService
import com.example.retrofit.api.BASE_URL
import com.example.retrofit.api.configuration.Deserializer
import com.example.retrofit.api.configuration.GlobalInterceptor
import com.example.retrofit.api.configuration.LiveDataCallAdapterFactory
import com.example.retrofit.data.User
import com.example.retrofit.executor.IOExecutors
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AuthModule {

    @Singleton
    @Provides
    fun provideIOExecutors(): IOExecutors = IOExecutors()

    @Singleton
    @Provides
    fun provideAuthApiService(): AuthApiService {
        val gson = GsonBuilder()
            .registerTypeAdapter(User::class.java, Deserializer<User>())
            .create()

        return getRetrofitBuilder(gson).create(AuthApiService::class.java)
    }

    private fun getRetrofitBuilder(gson: Gson) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(GlobalInterceptor.getOKHttpClientBuilded())
        .build()
}