package com.exomind.albums.dagger.module

import androidx.room.Room
import com.exomind.albums.AlbumsApplication
import com.exomind.albums.data.persistance.AppDatabase
import com.exomind.albums.data.persistance.dao.AlbumDao
import com.exomind.albums.data.persistance.dao.PhotosDao
import com.exomind.albums.data.persistance.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: AlbumsApplication): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): UserDao {
        return appDataBase.usersDaoDao()
    }

    @Provides
    fun providePhotoDao(appDataBase: AppDatabase): PhotosDao {
        return appDataBase.photosDao()
    }

    @Provides
    fun provideAlbumDao(appDataBase: AppDatabase): AlbumDao {
        return appDataBase.albumsDao()
    }
}