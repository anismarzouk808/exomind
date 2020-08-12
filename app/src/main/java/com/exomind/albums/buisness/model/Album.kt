package com.exomind.albums.buisness.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album (
    val id : Int,
    val userId : Int,
    val title : String
)  : Parcelable