package com.amneils.bostagi.dagger.module

import com.amneils.bostagi.services.providers.specificexampleApi.AlbumsApiProvider
import com.amneils.bostagi.services.providers.specificexampleApi.AlbumsApiService
import com.amneils.bostagi.services.providers.specificexampleApi.IAlbumsApiProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Singleton
    @Provides
    fun provideAlbumsApiProvider(apiService: AlbumsApiService): IAlbumsApiProvider =
        AlbumsApiProvider(apiService)

    @Singleton
    @Provides
    fun provideAlbumsService(retrofit: Retrofit): AlbumsApiService {
        return retrofit.create(AlbumsApiService::class.java)
    }
}