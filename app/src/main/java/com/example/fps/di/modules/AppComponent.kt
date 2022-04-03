package com.example.fps.di.modules

import com.example.fps.features.chapter_description.ChapterDescriptionFragment
import com.example.fps.features.chapters.ChapterFragment
import com.example.fps.features.main.MainActivity
import com.example.fps.features.main.MainFragment
import com.example.fps.features.settings.SettingsFragment
import com.example.fps.features.tests.TestFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NavigationModule::class,
        AppModule::class,
        ChapterModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(chapterFragment: ChapterFragment)
    fun inject(settingsFragment: SettingsFragment)
    fun inject(testFragment: TestFragment)
    fun inject(chapterDescriptionFragment: ChapterDescriptionFragment)
}