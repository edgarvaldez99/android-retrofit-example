package com.example.retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.Observer
import com.example.retrofit.api.*
import com.example.retrofit.data.LoginData
import com.example.retrofit.injection.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var authApiService: AuthApiService

    @Inject
    lateinit var freightageApiService: FreightageApiService

    lateinit var TOKEN: String

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder().build().inject(this)

        authApiService.login(LoginData("55555", "123456")).observe(this, Observer {
            when (it) {
                is ApiSuccessResponse -> {
                    TOKEN = it.body.data.authenticationToken
                    getSharedPreferences("USER", Context.MODE_PRIVATE).edit {
                        putString("TOKEN", TOKEN)
                    }

                    freightageApiService.getFreightage("$AUTH_KEY:$TOKEN").observe(this, Observer { res ->
                        when(res) {
                            is ApiSuccessResponse -> {
                                res.body.data.forEach { freightage ->
                                    Log.w(TAG, freightage.toString())
                                }
                            }
                            is ApiErrorResponse -> {
                                Log.e(TAG, res.errorMessage)
                            }
                            else -> Log.w(TAG, "Nothing happened")
                        }
                    })
                }
                else -> Log.w(TAG, it.toString())
            }
        })
    }
}
