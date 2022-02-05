package com.example.fps.navigation

import android.provider.Settings
import com.example.fps.chapters.ChapterFragment
import com.example.fps.features.main.MainFragment
import com.example.fps.settings.SettingsFragment
import com.example.fps.tests.TestFragment
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
}