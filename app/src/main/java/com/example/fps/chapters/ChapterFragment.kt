package com.example.fps.chapters

import android.os.Bundle
import com.example.fps.App
import com.example.fps.R
import com.example.fps.databinding.FragmentChapterBinding
import com.example.fps.features.base.BaseMvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ChapterFragment : BaseMvpFragment<FragmentChapterBinding, ChapterPresenter>(), IChapterView {
    @Inject
    lateinit var presenterProvider: Provider<ChapterPresenter>
    override val presenter: ChapterPresenter by moxyPresenter { presenterProvider.get() }
    override val layoutRes: Int by lazy { R.layout.fragment_chapter }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}