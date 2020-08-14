package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumsApiService {

    @GET("users")
    fun getUsers(): Single<List<UserDto>>


    @GET("users/{userId}/albums")
    fun getAlbums(@Path("userId") userId : Int): Single<List<AlbumDto>>

    @GET("users/1/photos")
    fun getAlbumPhotos(
        @Query("albumId") albumId : Int
    ) : Single<List<PhotoDto>>

}