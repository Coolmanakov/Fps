package com.example.fps.di.modules

import com.example.fps.chapters.ChapterFragment
import com.example.fps.features.main.MainActivity
import com.example.fps.features.main.MainFragment
import com.example.fps.settings.SettingsFragment
import com.example.fps.tests.TestFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules =[
        NavigationModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(chapterFragment: ChapterFragment)
    fun inject(settingsFragment: SettingsFragment)
    fun inject(testFragment: TestFragment)
}