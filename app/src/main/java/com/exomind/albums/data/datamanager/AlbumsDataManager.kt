package com.exomind.albums.data.datamanager

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.persistance.mapper.DBMapper
import com.exomind.albums.data.network.mapper.NetworkMapper
import com.exomind.albums.data.persistance.AppDatabase
import com.exomind.albums.services.providers.specificexampleApi.IAlbumsApiProvider
import io.reactivex.Single


class AlbumsDataManager(
    private val networkProvider: IAlbumsApiProvider,
    private val dataBase: AppDatabase
) : IAlbumsDataManger {

    override fun loadUsers(): Single<List<User>> {
        return dataBase.usersDao().getUsers().flatMap { users ->
            if (users.isEmpty()) networkProvider.getUsers()
            else Single.fromCallable{NetworkMapper().mapUsers(users)}
        }
    }

    override fun insertUsers(users : List<User>): Single<List<Long>> {
        val usersDto = DBMapper().mapUsersDto(users)
        return dataBase.usersDao().createAll(usersDto)
    }

    override fun loadAlbums(userId: Int): Single<List<Album>> {
        return dataBase.albumsDao().getAlbums(userId).flatMap { albums ->
            if (albums.isEmpty()) networkProvider.getAlbums(userId)
            else Single.fromCallable{NetworkMapper().mapAlbums(albums)}
        }
    }

    override fun insertAlbums(albums: List<Album>): Single<List<Long>> {
        val albumsDto = DBMapper().mapAlbumsDto(albums)
        return dataBase.albumsDao().createAll(albumsDto)
    }

    override fun loadPhotos(albumId: Int): Single<List<Photo>> {
        return dataBase.photosDao().getPhotos(albumId).flatMap { photos ->
            if (photos.isEmpty()) networkProvider.getPhotos(albumId)
            else Single.fromCallable{ NetworkMapper().mapPhotos(photos)}
        }
    }

    override fun insertPhotos(photos: List<Photo>): Single<List<Long>> {
        val photosDto = DBMapper().mapPhotosDto(photos)
        return dataBase.photosDao().createAll(photosDto)
    }
}

interface IAlbumsDataManger {
    fun loadUsers(): Single<List<User>>
    fun loadAlbums(userId: Int): Single<List<Album>>
    fun loadPhotos(albumId: Int): Single<List<Photo>>
    fun insertUsers(users : List<User>) : Single<List<Long>>
    fun insertAlbums(albums : List<Album>) : Single<List<Long>>
    fun insertPhotos(photos : List<Photo>) : Single<List<Long>>
}