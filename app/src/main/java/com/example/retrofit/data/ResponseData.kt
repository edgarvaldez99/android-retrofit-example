package com.example.retrofit.data

import com.google.gson.annotations.SerializedName

class ResponseData <T> (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T
)