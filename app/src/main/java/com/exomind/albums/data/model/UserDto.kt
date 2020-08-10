package com.exomind.albums.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserDto(

    @SerializedName("id")
    @PrimaryKey
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("username")
    @ColumnInfo(name = "user_name")
    val pseudo: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("website")
    @ColumnInfo(name = "web_site")
    val webSite: String? = null

)