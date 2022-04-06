package com.example.fps.features.chapters

import com.example.fps.models.Chapter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEnd
interface IChapterView : MvpView {

    @AddToEndSingle
    fun updateUiModel(chapterList: List<Chapter>)
}