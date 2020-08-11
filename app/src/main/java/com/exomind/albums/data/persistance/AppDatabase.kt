package com.exomind.albums.data.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto
import com.exomind.albums.data.persistance.dao.AlbumDao
import com.exomind.albums.data.persistance.dao.PhotosDao
import com.exomind.albums.data.persistance.dao.UserDao

@Database(entities = [UserDto::class,PhotoDto::class, AlbumDto::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "albums.db"
        const val VERSION = 1
    }

    abstract fun usersDaoDao(): UserDao
    abstract fun albumsDao(): AlbumDao
    abstract fun photosDao(): PhotosDao
}