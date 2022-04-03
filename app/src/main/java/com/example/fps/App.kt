package com.example.fps

import android.app.Application
import com.example.fps.di.modules.AppComponent
import com.example.fps.di.modules.AppModule
import com.example.fps.di.modules.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()
    }

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }
}