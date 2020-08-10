package com.amneils.bostagi.dagger.module

import com.exomind.albums.ui.main.MainActivity
import com.exomind.albums.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}