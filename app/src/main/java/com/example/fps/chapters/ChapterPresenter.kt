package com.example.fps.chapters

import com.example.fps.features.base.BasePresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ChapterPresenter @Inject constructor(private val router: Router) : BasePresenter<IChapterView>() {
}