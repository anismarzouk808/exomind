package com.exomind.albums.services.providers.specificexampleApi

import com.exomind.albums.data.model.UserDto
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumsApiService {

    @GET("users")
    fun getUsers(): Single<List<UserDto>>


}