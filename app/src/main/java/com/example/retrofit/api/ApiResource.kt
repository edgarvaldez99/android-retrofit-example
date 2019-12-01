package com.example.retrofit.api

data class ApiResource<out T>(val status: ApiResourceStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): ApiResource<T> {
            return ApiResource(ApiResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ApiResource<T> {
            return ApiResource(ApiResourceStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ApiResource<T> {
            return ApiResource(ApiResourceStatus.LOADING, data, null)
        }
    }
}
