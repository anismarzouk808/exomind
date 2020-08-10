package com.exomind.albums.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "albums")
data class Album (
    @SerializedName("id")
    @PrimaryKey
    val id : Int? = null,

    @SerializedName("userId")
    @ColumnInfo(name = "user_id")
    val userId : Int? = null,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title : String? = null
)