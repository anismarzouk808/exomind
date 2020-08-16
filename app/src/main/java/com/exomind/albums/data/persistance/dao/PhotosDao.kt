package com.exomind.albums.data.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto
import io.reactivex.Single

@Dao
interface PhotosDao {
    @Query("SELECT * FROM photos WHERE album_id = :albumId")
    fun getPhotos(albumId : Int) : Single<List<PhotoDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createAll(photos : List<PhotoDto>) : Single<List<Long>>

}