package com.example.retrofit.injection.module

import com.example.retrofit.api.FreightageApiService
import com.example.retrofit.api.configuration.Deserializer
import com.example.retrofit.data.Freightage
import com.example.retrofit.api.ResponseData
import com.example.retrofit.utils.getRetrofitBuilder
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FreightageModule {
    @Singleton
    @Provides
    fun provideAuthApiService(): FreightageApiService {
        val type = object : TypeToken<ResponseData<List<Freightage>>>() {}.type
        val mapper = GsonBuilder()
            .registerTypeAdapter(type, Deserializer<ResponseData<List<Freightage>>>())
            .create()

        return getRetrofitBuilder(mapper).create(FreightageApiService::class.java)
    }
}