package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.UserDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumsApiService {

    @GET("users")
    fun getUsers(): Single<List<UserDto>>


    @GET("users/{userId}/albums")
    fun getAlbums(@Path("userId") userId : Int): Single<List<AlbumDto>>

}