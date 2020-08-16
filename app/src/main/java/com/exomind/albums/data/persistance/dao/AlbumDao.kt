package com.exomind.albums.data.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exomind.albums.data.model.AlbumDto
import io.reactivex.Single

@Dao
interface AlbumDao {

    @Query("SELECT * FROM albums WHERE user_id =  :userId")
    fun getAlbums(userId : Int) : Single<List<AlbumDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createAll(albums : List<AlbumDto>) : Single<List<Long>>

}