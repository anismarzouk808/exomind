package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.mapper.AlbumsMapper
import io.reactivex.Single

class AlbumsApiProvider(private val apiService: AlbumsApiService) : IAlbumsApiProvider {

    override fun getUsers() : Single<List<User>> {
       return apiService.getUsers().map {
           AlbumsMapper().filterUsersDto(it)
       }.map { AlbumsMapper().mapListUsers(it) }
    }

    override fun getAlbums(userId : Int): Single<List<Album>> {
        return apiService.getAlbums(userId).map { AlbumsMapper().mapAlbums(it) }
    }

    override fun getAlbumPhotos(userId : Int, albumId : Int): Single<List<Photo>> {
        return apiService.getAlbumPhotos(userId,albumId).map {
            AlbumsMapper().mapAlbumPhoto(it)
        }
    }
}


interface IAlbumsApiProvider {
    fun getUsers() :Single<List<User>>
    fun getAlbums(userId : Int) :Single<List<Album>>
    fun getAlbumPhotos(userId : Int, albumId : Int) :Single<List<Photo>>
}