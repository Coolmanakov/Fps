package com.example.fps.tests

import android.os.Bundle
import com.example.fps.App
import com.example.fps.R
import com.example.fps.databinding.FragmentSettingsBinding
import com.example.fps.features.base.BaseMvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class TestFragment : BaseMvpFragment<FragmentSettingsBinding, TestPresenter>(), ITestView {
    @Inject
    lateinit var presenterProvider: Provider<TestPresenter>
    override val presenter: TestPresenter by moxyPresenter { presenterProvider.get() }

    override val layoutRes: Int by lazy { R.layout.fragment_settings }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}