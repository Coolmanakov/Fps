package com.example.fps.features.chapter_description

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.os.bundleOf
import com.example.fps.App
import com.example.fps.BuildConfig
import com.example.fps.R
import com.example.fps.databinding.FragmentChapterDescriptionBinding
import com.example.fps.features.base.BaseMvpFragment
import com.example.fps.features.chapters.ChapterAdapter
import com.example.fps.features.chapters.OnChapterItemClickListener
import com.example.fps.models.Chapter
import moxy.ktx.moxyPresenter
import java.io.File
import javax.inject.Inject
import javax.inject.Provider


class ChapterDescriptionFragment :
    BaseMvpFragment<FragmentChapterDescriptionBinding, ChapterDescriptionPresenter>(),
    IChapterDescription {
    @Inject
    lateinit var presenterProvider: Provider<ChapterDescriptionPresenter>
    override val presenter: ChapterDescriptionPresenter by moxyPresenter { presenterProvider.get() }
    override val layoutRes: Int by lazy { R.layout.fragment_chapter_description }
    private val onChapterItemListener: OnChapterItemClickListener by lazy {
        object : OnChapterItemClickListener {
            override fun onItemClick(chapterName: String) {
                openFile(chapterPath + File.separator + chapterName)
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

    override fun updateUiModel(chapterDescriptionList: List<Chapter>) {
        chapterAdapter.submitList(chapterDescriptionList)
        binding?.chapterDescriptionRecycler?.adapter = chapterAdapter
    }

    private fun openFile(path: String) {
        val absolutePath = presenter.getExternalStoragePath() + File.separator + path
        val file = File(absolutePath)
        val uri = if (Build.VERSION.SDK_INT >= 24) FileProvider.getUriForFile(
            requireContext(),
            BuildConfig.APPLICATION_ID + ".provider",
            file
        ) else Uri.fromFile(file)
        val target = Intent(Intent.ACTION_VIEW)

        target.setDataAndType(uri, "application/pdf")
        target.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        val intent = Intent.createChooser(target, "Open File")

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), R.string.failed_open_pdf, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val CHAPTER_DESCRIPTION_PATH = "chapterPath"
        fun newInstance(path: String) =
            ChapterDescriptionFragment().apply {
                arguments = bundleOf(CHAPTER_DESCRIPTION_PATH to path)
            }
    }

}
