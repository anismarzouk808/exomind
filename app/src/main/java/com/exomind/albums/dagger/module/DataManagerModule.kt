package com.exomind.albums.dagger.module


import com.exomind.albums.services.providers.specificexampleApi.IAlbumsApiProvider
import com.exomind.albums.data.datamanager.AlbumsDataManager
import com.exomind.albums.data.datamanager.IAlbumsDataManger
import com.exomind.albums.data.persistance.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataManagerModule {

    @Provides
    fun provideAlbumsDataManager(albumsApiProvider: IAlbumsApiProvider,db : AppDatabase): IAlbumsDataManger =
        AlbumsDataManager(albumsApiProvider,db)
}