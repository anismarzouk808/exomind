package com.amneils.bostagi.dagger.module


import com.amneils.bostagi.services.providers.specificexampleApi.IAlbumsApiProvider
import com.exomind.albums.data.datamanager.AlbumsDataManager
import com.exomind.albums.data.datamanager.IAlbumsDataManger
import com.exomind.albums.data.persistance.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataManagerModule {
    @Provides
    fun provideAlbumsDataManager(albumsApiProvider: IAlbumsApiProvider,appDatabase: AppDatabase): IAlbumsDataManger =
        AlbumsDataManager(albumsApiProvider,appDatabase)
}