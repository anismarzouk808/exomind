package com.exomind.albums.buisness.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int = 0,
    val name: String = "",
    val pseudo: String = "",
    val email: String = "",
    val phone: String = "",
    val webSite: String = ""
) : Parcelable