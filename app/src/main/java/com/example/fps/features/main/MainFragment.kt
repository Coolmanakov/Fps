package com.example.fps.features.main

import android.os.Bundle
import com.example.fps.App
import com.example.fps.R
import com.example.fps.databinding.FragmentMainBinding
import com.example.fps.features.base.BaseMvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class MainFragment : BaseMvpFragment<FragmentMainBinding, MainPresenter>(), IMainView {

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>
    override val presenter: MainPresenter by moxyPresenter { presenterProvider.get() }

    override val layoutRes: Int by lazy { R.layout.fragment_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun exit() = activity?.finish() ?: Unit
}