package com.example.retrofit.api

import androidx.lifecycle.LiveData
import com.example.retrofit.data.Freightage
import com.example.retrofit.data.ResponseData
import retrofit2.http.GET
import retrofit2.http.Header

interface FreightageApiService {

    @GET("usuarios/fletes/listar")
    fun getFreightage(@Header("Authorization") token: String): LiveData<ApiResponse<ResponseData<List<Freightage>>>>
}