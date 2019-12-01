package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.retrofit.api.AuthApiService
import com.example.retrofit.data.LoginData
import com.example.retrofit.injection.DaggerAuthComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var authApiService: AuthApiService

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAuthComponent.builder().build().inject(this);

        authApiService.login(LoginData("55555", "123456")).observe(this, Observer {
            Log.w(TAG, it.toString())
        })
    }
}
