package com.amneils.bostagi.services.providers.specificexampleApi

import javax.inject.Singleton

@Singleton
class AlbumsApiProvider(private val apiService: AlbumsApiService) : IAlbumsApiProvider {
}


interface IAlbumsApiProvider {

}