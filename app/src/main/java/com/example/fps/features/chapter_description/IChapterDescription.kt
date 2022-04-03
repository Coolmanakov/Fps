package com.example.fps.features.chapter_description

import com.example.fps.models.Chapter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface IChapterDescription : MvpView {
    @AddToEndSingle
    fun updateUiModel(chapterDescriptionList: List<Chapter>)
}