package com.example.fps.features.settings

import android.os.Bundle
import com.example.fps.App
import com.example.fps.R
import com.example.fps.databinding.FragmentSettingsBinding
import com.example.fps.features.base.BaseMvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class SettingsFragment : BaseMvpFragment<FragmentSettingsBinding, SettingsPresenter>(), ISettingsView {
    @Inject
    lateinit var presenterProvider: Provider<SettingsPresenter>
    override val presenter: SettingsPresenter by moxyPresenter { presenterProvider.get() }
    override val layoutRes by lazy { R.layout.fragment_settings }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}