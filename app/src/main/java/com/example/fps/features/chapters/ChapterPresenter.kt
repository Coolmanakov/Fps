package com.example.fps.features.chapters

import com.example.fps.domain.ChapterInteractor
import com.example.fps.features.base.BasePresenter
import com.example.fps.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ChapterPresenter @Inject constructor(
    private val router: Router,
    private val chapterInteractor: ChapterInteractor
) : BasePresenter<IChapterView>() {

    fun getChapters(){
        val chapterList = chapterInteractor.getChapters()
        viewState.updateUiModel(chapterList)
    }

    fun navigateToChapterDescription(chapterName: String) = router.navigateTo(Screens.chapterDescription(chapterName))

    fun navigateFromChapterScreen() = router.exit()
}