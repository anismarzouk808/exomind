package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.network.mapper.NetworkMapper
import io.reactivex.Single

class AlbumsApiProvider(private val apiService: AlbumsApiService) : IAlbumsApiProvider {

    override fun getUsers() : Single<List<User>> {
       return apiService.getUsers().map { NetworkMapper().mapUsers(it) }
    }

    override fun getAlbums(userId : Int): Single<List<Album>> {
        return apiService.getAlbums(userId).map { NetworkMapper().mapAlbums(it) }
    }

    override fun getPhotos(albumId : Int): Single<List<Photo>> {
        return apiService.getAlbumPhotos(albumId).map {
            NetworkMapper().mapPhotos(it)
        }
    }
}


interface IAlbumsApiProvider {
    fun getUsers() :Single<List<User>>
    fun getAlbums(userId : Int) :Single<List<Album>>
    fun getPhotos(albumId : Int) :Single<List<Photo>>
}