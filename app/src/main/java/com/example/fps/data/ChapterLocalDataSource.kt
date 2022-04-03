package com.example.fps.data

import android.os.Environment
import com.example.fps.models.Chapter
import java.io.File
import javax.inject.Inject

class ChapterLocalDataSource @Inject constructor() : IChapterLocalDataSource {

    override fun getChapterList(): List<Chapter> {
        val chapterFolder = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            CHAPTER_FOLDER_NAME
        )
        return if (!chapterFolder.exists()) {
            chapterFolder.mkdir()
            emptyList()
        } else {
            chapterFolder.listFiles()?.let { fileList ->
                fileList.filter { file -> file.extension == "" }
                    .map { chapter -> Chapter(chapter.name) }
            } ?: emptyList()
        }
    }

    override fun getChapterDescription(path: String): List<Chapter> {
        val chapterFolder = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            CHAPTER_FOLDER_NAME + File.separator + path
        )
        return if (chapterFolder.exists()) {
            chapterFolder.listFiles()?.let { fileList ->
                fileList.map { chapterDescription -> Chapter(chapterDescription.name) }
            } ?: emptyList()
        } else emptyList()
    }

    companion object {
        private const val CHAPTER_FOLDER_NAME = "ФПС"
    }
}

interface IChapterLocalDataSource{
    fun getChapterList(): List<Chapter>
    fun getChapterDescription(path: String): List<Chapter>
}