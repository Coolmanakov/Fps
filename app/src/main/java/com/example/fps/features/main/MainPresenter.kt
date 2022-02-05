package com.example.fps.features.main

import com.example.fps.features.base.BasePresenter
import com.example.fps.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<IMainView>() {

    fun showChapters() = router.navigateTo(Screens.Chapter)

    fun showSettings() = router.navigateTo(Screens.Settings)

    fun showTests() = router.navigateTo(Screens.Test)

    fun exit() = viewState.exit()
}