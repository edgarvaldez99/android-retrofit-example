package com.example.retrofit.injection.module

import com.example.retrofit.api.FreightageApiService
import com.example.retrofit.api.configuration.DeserializerList
import com.example.retrofit.api.configuration.getRetrofitBuilder
import com.example.retrofit.data.FreightageList
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
        val itemType = object : TypeToken<FreightageList>() {}.type
        val mapper = GsonBuilder()
            .registerTypeAdapter(itemType, DeserializerList<FreightageList>())
            .create()

        return getRetrofitBuilder(mapper).create(FreightageApiService::class.java)
    }
}