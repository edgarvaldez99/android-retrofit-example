package com.example.retrofit.injection

import dagger.Component
import javax.inject.Singleton
import com.example.retrofit.MainActivity

@Singleton
@Component(modules = [ AuthModule::class ])
interface AuthComponent {
    fun inject(mainActivity: MainActivity)
}