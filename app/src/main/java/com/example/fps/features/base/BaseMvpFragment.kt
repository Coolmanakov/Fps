package com.example.fps.features.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.fps.BR
import moxy.MvpAppCompatFragment

abstract class BaseMvpFragment<Binding : ViewDataBinding, Presenter : BasePresenter<*>> : MvpAppCompatFragment() {

    protected var binding: Binding? = null
    protected abstract val layoutRes: Int
    protected open val presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding?.apply {
            setVariable(BR.presenter, presenter)
            onBindingCreated(this)
            lifecycleOwner = viewLifecycleOwner
        }
        return binding?.root
    }

    open fun onBindingCreated(binding: Binding) = Unit
}