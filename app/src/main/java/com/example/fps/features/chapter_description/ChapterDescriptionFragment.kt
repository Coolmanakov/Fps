package com.example.fps.features.chapter_description

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.fps.App
import com.example.fps.R
import com.example.fps.databinding.FragmentChapterDescriptionBinding
import com.example.fps.features.base.BaseMvpFragment
import com.example.fps.features.chapters.ChapterAdapter
import com.example.fps.features.chapters.OnChapterItemClickListener
import com.example.fps.models.Chapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ChapterDescriptionFragment : BaseMvpFragment<FragmentChapterDescriptionBinding, ChapterDescriptionPresenter>(), IChapterDescription {
    @Inject
    lateinit var presenterProvider: Provider<ChapterDescriptionPresenter>
    override val presenter: ChapterDescriptionPresenter by moxyPresenter { presenterProvider.get() }
    override val layoutRes: Int by lazy { R.layout.fragment_chapter_description }
    private val onChapterItemListener: OnChapterItemClickListener by lazy {
        object : OnChapterItemClickListener {
            override fun onItemClick(chapterName: String) {

            }
        }
    }
    private val chapterAdapter: ChapterAdapter by lazy { ChapterAdapter(onChapterItemListener) }
    private val chapterPath: String by lazy {
        arguments?.getString(CHAPTER_DESCRIPTION_PATH) ?: ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        presenter.getChapterDescription(chapterPath)
    }

    companion object {
        private const val CHAPTER_DESCRIPTION_PATH = "chapterPath"
        fun newInstance(path: String) =
            ChapterDescriptionFragment().apply {
                arguments = bundleOf( CHAPTER_DESCRIPTION_PATH to path)
            }
    }

    override fun updateUiModel(chapterDescriptionList: List<Chapter>) {
        chapterAdapter.submitList(chapterDescriptionList)
        binding?.chapterDescriptionRecycler?.adapter = chapterAdapter
    }

}