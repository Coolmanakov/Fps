package com.example.fps.features.main

import android.os.Bundle
import com.example.fps.App
import com.example.fps.R
import com.example.fps.features.base.BaseActivity
import com.example.fps.navigation.Screens
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpView
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: Router
    override val navigator: Navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.newRootScreen(Screens.Main)
    }
}