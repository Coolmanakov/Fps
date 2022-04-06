package com.example.fps.features.chapter_description

import com.example.fps.domain.ChapterInteractor
import com.example.fps.features.base.BasePresenter
import javax.inject.Inject

class ChapterDescriptionPresenter @Inject constructor(
    private val chapterInteractor: ChapterInteractor
) : BasePresenter<IChapterDescription>() {

    fun getChapterDescription(path: String) {
        val chapterDescription = chapterInteractor.getChapterDescription(path)
        viewState.updateUiModel(chapterDescription)
    }

    fun getExternalStoragePath(): String = chapterInteractor.getExternalStoragePath()
}