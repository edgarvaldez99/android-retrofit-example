package com.example.retrofit.api

import androidx.lifecycle.LiveData
import com.example.retrofit.data.LoginData
import com.example.retrofit.data.ResponseData
import com.example.retrofit.data.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("usuarios/login")
    fun login(@Body loginData: LoginData): LiveData<ApiResponse<ResponseData<User>>>

    @POST("usuarios/logout")
    fun logout()
}