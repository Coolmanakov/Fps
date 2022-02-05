package com.example.fps.features.main

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMainView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun exit()
}