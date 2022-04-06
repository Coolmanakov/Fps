package com.example.fps.domain

import com.example.fps.data.IChapterLocalDataSource
import com.example.fps.models.Chapter
import javax.inject.Inject

class ChapterInteractor @Inject constructor(
    private val chapterLocalDataSource: IChapterLocalDataSource
) : IChapterInteractor {

    override fun getChapters(): List<Chapter> = chapterLocalDataSource.getChapterList()

    override fun getChapterDescription(path: String): List<Chapter> =
        chapterLocalDataSource.getChapterDescription(path)

    override fun getExternalStoragePath(): String = chapterLocalDataSource.getExternalStoragePath()

}

interface IChapterInteractor {
    /**
     * Получаем список разделов из папки
     */
    fun getChapters(): List<Chapter>

    fun getChapterDescription(path: String): List<Chapter>

    fun getExternalStoragePath(): String
}