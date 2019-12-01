package com.example.retrofit.injection

import dagger.Component
import javax.inject.Singleton
import com.example.retrofit.MainActivity
import com.example.retrofit.injection.module.AuthModule
import com.example.retrofit.injection.module.FreightageModule

@Singleton
@Component(modules = [ AuthModule::class, FreightageModule::class ])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}