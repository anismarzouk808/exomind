package com.exomind.albums.data.datamanager

import com.exomind.albums.services.providers.specificexampleApi.IAlbumsApiProvider
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.persistance.AppDatabase
import io.reactivex.Single


class AlbumsDataManager(
    private val provider: IAlbumsApiProvider,
    private val dataBase: AppDatabase
) : IAlbumsDataManger {

    override fun loadUsers() : Single<List<User>> {
       return provider.getUsers().doOnSuccess {
           //save on db
       }
    }
}

interface IAlbumsDataManger{
    fun loadUsers() : Single<List<User>>
}