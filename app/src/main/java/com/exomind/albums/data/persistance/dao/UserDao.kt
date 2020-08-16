package com.exomind.albums.data.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exomind.albums.data.model.UserDto
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers() : Single<List<UserDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun createAll(users : List<UserDto>) : Single<List<Long>>
}