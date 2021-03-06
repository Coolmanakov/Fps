package com.example.fps.navigation

import com.example.fps.features.chapter_description.ChapterDescriptionFragment
import com.example.fps.features.chapters.ChapterFragment
import com.example.fps.features.main.MainFragment
import com.example.fps.features.settings.SettingsFragment
import com.example.fps.features.tests.TestFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    val Main
        get() = FragmentScreen {
            MainFragment()
        }

    val Chapter
        get() = FragmentScreen {
            ChapterFragment()
        }

    val Settings
        get() = FragmentScreen {
            SettingsFragment()
        }

    val Test
        get() = FragmentScreen {
            TestFragment()
        }

    fun chapterDescription(path: String) = FragmentScreen {
            ChapterDescriptionFragment.newInstance(path)
        }
}