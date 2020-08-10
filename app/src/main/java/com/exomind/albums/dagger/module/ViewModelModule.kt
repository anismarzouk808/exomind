package com.exomind.albums.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exomind.albums.dagger.factory.AppViewModelFactory
import com.exomind.albums.dagger.annotation.ViewModelKey
import com.exomind.albums.ui.main.albums.AlbumViewModel
import com.exomind.albums.ui.main.albumsphotos.AlbumPhotosViewModel
import com.exomind.albums.ui.main.users.UsersViewModel
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
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun provideSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    internal abstract fun provideUsersViewModel(usersViewModel: UsersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumViewModel::class)
    internal abstract fun provideAlbumViewModel(albumViewModel: AlbumViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumPhotosViewModel::class)
    internal abstract fun provideAlbumPhotosViewModel(splashViewModel: AlbumPhotosViewModel): ViewModel

}