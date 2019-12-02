package com.example.retrofit.api

import androidx.lifecycle.LiveData
import com.example.retrofit.data.Freightage
import retrofit2.http.GET
import retrofit2.http.Header

interface FreightageApiService {

    @GET("usuarios/fletes/listar")
    fun getFreightage(@Header("Authorization") token: String): LiveData<ResponseStatus<ResponseData<List<Freightage>>>>
}