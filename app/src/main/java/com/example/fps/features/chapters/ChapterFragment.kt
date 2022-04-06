package com.example.fps.features.chapters

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.fps.App
import com.example.fps.BuildConfig
import com.example.fps.R
import com.example.fps.databinding.FragmentChapterBinding
import com.example.fps.features.base.BaseMvpFragment
import com.example.fps.models.Chapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ChapterFragment : BaseMvpFragment<FragmentChapterBinding, ChapterPresenter>(), IChapterView {
    @Inject
    lateinit var presenterProvider: Provider<ChapterPresenter>
    override val presenter: ChapterPresenter by moxyPresenter { presenterProvider.get() }
    override val layoutRes: Int by lazy { R.layout.fragment_chapter }
    private val onChapterItemListener: OnChapterItemClickListener by lazy {
        object : OnChapterItemClickListener {
            override fun onItemClick(chapterName: String) {
                presenter.navigateToChapterDescription(chapterName)
            }
        }
    }
    private val externalPermissionContract =
        registerForActivityResult(RequestPermission()) { isAccepted ->
            if (isAccepted) presenter.getChapters()
            else {
                Toast.makeText(
                    requireContext(),
                    R.string.on_deny_write_external_permission_text,
                    Toast.LENGTH_LONG
                ).show()
                presenter.navigateFromChapterScreen()
            }
        }
    private val chapterAdapter: ChapterAdapter by lazy { ChapterAdapter(onChapterItemListener) }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStart() {
        super.onStart()
        checkPermission()
    }


    fun checkPermission() {
        if (Build.VERSION.SDK_INT < 30) getPermissionLowSdk()
        else getPermissionHighSdk()
    }

    private fun getPermissionLowSdk() {
        if (checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        )
            presenter.getChapters()
        else externalPermissionContract.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun getPermissionHighSdk() {
        when {
            Environment.isExternalStorageManager() -> presenter.getChapters()
            else -> acceptExternalStorageManager()
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun acceptExternalStorageManager() {
        val uri = Uri.parse("package:" + BuildConfig.APPLICATION_ID);
        val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri);
        requireContext().startActivity(intent)
    }

    override fun updateUiModel(chapterList: List<Chapter>) {
        chapterAdapter.submitList(chapterList)
        binding?.chapterRecycler?.adapter = chapterAdapter
    }

}
