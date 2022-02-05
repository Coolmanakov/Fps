package com.example.fps

import android.app.Application
import com.example.fps.di.modules.AppComponent
import com.example.fps.di.modules.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }
}