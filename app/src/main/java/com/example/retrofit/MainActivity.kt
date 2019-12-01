package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.retrofit.api.AuthApiService
import com.example.retrofit.api.BASE_URL
import com.example.retrofit.api.configuration.GlobalInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.example.retrofit.api.configuration.Deserializer
import com.example.retrofit.api.configuration.LiveDataCallAdapterFactory
import com.example.retrofit.data.LoginData
import com.example.retrofit.data.User
import com.google.gson.Gson
import kotlin.reflect.KClass
import kotlin.reflect.KTypeProjection
import kotlin.reflect.full.declaredFunctions

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authApiService = getAuthApiService()
        authApiService.login(LoginData("55555", "123456")).observe(this, Observer {
            Log.w(TAG, it.toString())
        })
    }

    private fun getAuthApiService(): AuthApiService {
        val gson = GsonBuilder()
            .registerTypeAdapter(User::class.java, Deserializer<User>())
            .create()

        return getRetrofitBuilder(gson).create(AuthApiService::class.java)
    }

    private fun getRetrofitBuilder(gson: Gson) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(OkHttpClient.Builder().addInterceptor(GlobalInterceptor()).build())
        .build()
}
