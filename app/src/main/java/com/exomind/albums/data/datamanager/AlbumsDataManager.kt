package com.exomind.albums.data.datamanager

import com.amneils.bostagi.services.providers.specificexampleApi.IAlbumsApiProvider
import com.exomind.albums.data.persistance.AppDatabase


class AlbumsDataManager(
    private val provider: IAlbumsApiProvider,
    private val appDatabase: AppDatabase
) : IAlbumsDataManger

interface IAlbumsDataManger