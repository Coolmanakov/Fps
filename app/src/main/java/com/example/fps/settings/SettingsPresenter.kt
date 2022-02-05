package com.example.fps.settings

import com.example.fps.features.base.BasePresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SettingsPresenter @Inject constructor(private val router: Router): BasePresenter<ISettingsView>() {
}