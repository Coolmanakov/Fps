package com.example.fps.features.base

import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import moxy.MvpAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(){

    abstract val navigator: Navigator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
