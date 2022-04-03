package com.example.fps.di.modules

import com.example.fps.data.ChapterLocalDataSource
import com.example.fps.data.IChapterLocalDataSource
import com.example.fps.domain.ChapterInteractor
import com.example.fps.domain.IChapterInteractor
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ChapterModule {

    @Binds
    @Singleton
    fun provideChapterInteractor(chapterInteractor: ChapterInteractor): IChapterInteractor

    @Binds
    @Singleton
    fun provideChapterLocalDataSource(chapterLocalDataSource: ChapterLocalDataSource): IChapterLocalDataSource

}