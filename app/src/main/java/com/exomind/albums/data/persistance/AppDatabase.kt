package com.exomind.albums.data.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exomind.albums.data.model.Album
import com.exomind.albums.data.model.Photo
import com.exomind.albums.data.model.User
import com.exomind.albums.data.persistance.dao.AlbumDao
import com.exomind.albums.data.persistance.dao.PhotosDao
import com.exomind.albums.data.persistance.dao.UserDao

@Database(entities = [User::class,Photo::class, Album::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "albums.db"
        const val VERSION = 1
    }

    abstract fun usersDaoDao(): UserDao
    abstract fun albumsDao(): AlbumDao
    abstract fun photosDao(): PhotosDao
}