package com.exomind.albums.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos")
data class PhotoDto (
    @SerializedName("id")
    @PrimaryKey
    val id : Int? = null,

    @SerializedName("albumId")
    @ColumnInfo(name = "album_id")
    val albumId : Int? = null,

    @SerializedName("title")
    val title : String,

    @SerializedName("url")
    val url : String? = null,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl : String? = null
)