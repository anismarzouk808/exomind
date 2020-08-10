package com.amneils.bostagi.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amneils.bostagi.dagger.factory.AppViewModelFactory
import com.amneils.bostagi.ui.main.MainViewModel
import com.exomind.albums.dagger.annotation.ViewModelKey
import com.exomind.albums.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun provideSplashViewModel(splashViewModel: SplashViewModel): ViewModel

}