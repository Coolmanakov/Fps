package com.example.fps.features.tests

import com.example.fps.features.base.BasePresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class TestPresenter @Inject constructor(private val router: Router): BasePresenter<ITestView>() {
}