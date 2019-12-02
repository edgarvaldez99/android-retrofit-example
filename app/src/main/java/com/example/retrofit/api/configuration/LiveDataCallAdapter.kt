package com.example.retrofit.api.configuration

import androidx.lifecycle.LiveData
import com.example.retrofit.api.ResponseStatus
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 * @param <R>
</R> */
class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<R, LiveData<ResponseStatus<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<ResponseStatus<R>> {
        return object : LiveData<ResponseStatus<R>>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(ResponseStatus.create(response))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(ResponseStatus.create(throwable))
                        }
                    })
                }
            }
        }
    }
}
