package com.amneils.bostagi.dagger.module

import com.exomind.albums.ui.main.albums.AlbumsFragment
import com.exomind.albums.ui.main.albumsphotos.AlbumPhotosFragment
import com.exomind.albums.ui.main.users.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule{

    @ContributesAndroidInjector
    internal abstract fun contributeUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAlbumsFragment(): AlbumsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAlbumPhotosFragment(): AlbumPhotosFragment
}