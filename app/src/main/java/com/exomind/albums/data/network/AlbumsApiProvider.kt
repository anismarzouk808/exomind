package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.mapper.AlbumsMapper
import io.reactivex.Single

class AlbumsApiProvider(private val apiService: AlbumsApiService) : IAlbumsApiProvider {
    override fun getUsers() : Single<List<User>> {
       return apiService.getUsers().map {
           AlbumsMapper().filterUsersDto(it)
       }.map { AlbumsMapper().mapListUsers(it) }
    }
}


interface IAlbumsApiProvider {
    fun getUsers() :Single<List<User>>
}