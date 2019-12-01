package com.example.retrofit.api

import android.util.Log
import retrofit2.Response
import java.util.regex.Pattern

/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */
@Suppress("unused") // T is used in extending classes
sealed class ApiResponse<T> {

    /**
     * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
     */
    class ApiEmptyResponse<T> : ApiResponse<T>()
    data class ApiErrorResponse<T>(val errorMessage: String) : ApiResponse<T>()
    data class ApiSuccessResponse<T>(
        val body: T,
        val links: Map<String, String>
    ) : ApiResponse<T>() {
        constructor(body: T, linkHeader: String?) : this(
            body = body,
            links = linkHeader?.extractLinks() ?: emptyMap()
        )

        val nextPage: Int? by lazy(LazyThreadSafetyMode.NONE) {
            links[NEXT_LINK]?.let { next ->
                val matcher = PAGE_PATTERN.matcher(next)
                if (!matcher.find() || matcher.groupCount() != 1) {
                    null
                } else {
                    try {
                        val m = matcher.group(1) ?: "0"
                        Integer.parseInt(m)
                    } catch (ex: NumberFormatException) {
                        Log.w(ApiResponse::class.java.simpleName, "cannot parse next page from $next")
                        null
                    }
                }
            }
        }

        companion object {
            private val LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"")
            private val PAGE_PATTERN = Pattern.compile("\\bpage=(\\d+)")
            private const val NEXT_LINK = "next"

            private fun String.extractLinks(): Map<String, String> {
                val links = mutableMapOf<String, String>()
                val matcher = LINK_PATTERN.matcher(this)

                while (matcher.find()) {
                    val count = matcher.groupCount()
                    if (count == 2) {
                        val m1 = matcher.group(1)
                        val m2 = matcher.group(2)
                        m1?.let {
                            m2?.let { m ->
                                links[m] = it
                            }
                        }
                    }
                }
                return links
            }

        }
    }

    companion object {
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "unknown error")
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(
                        body = body,
                        linkHeader = response.headers()?.get("link")
                    )
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                ApiErrorResponse(errorMsg ?: "unknown error")
            }
        }
    }
}