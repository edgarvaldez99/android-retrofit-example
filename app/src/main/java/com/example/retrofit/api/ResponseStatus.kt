package com.example.retrofit.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response


/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */
@Suppress("unused") // T is used in extending classes
sealed class ResponseStatus<T> {

    companion object {
        fun <T> create(error: Throwable): ResponseStatus<T> {
            return ErrorResponse(error.message ?: "unknown error", -1)
        }

        fun <T> create(response: Response<T>): ResponseStatus<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) EmptyResponse()
                else SuccessResponse(body)
            } else {
                val json = response.errorBody()?.string()
                if (!json.isNullOrEmpty()) {
                    return try {
                        val token = object : TypeToken<ErrorResponse<T>>() {}.type
                        Gson().fromJson<ErrorResponse<T>>(json, token)
                    } catch (th: Throwable) {
                        ErrorResponse(response.message(), -1)
                    }
                }
                ErrorResponse("unknown error", -1)
            }
        }
    }
}

/**
 * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */
class EmptyResponse<T> : ResponseStatus<T>()
data class ErrorResponse<T>(val message: String, val code: Int) : ResponseStatus<T>()
data class SuccessResponse<T>(val body: T) : ResponseStatus<T>()
