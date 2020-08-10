package com.exomind.albums.buisness.model

data class User(
    val id: Int,
    val name: String,
    val pseudo: String,
    val email: String,
    val phone: String,
    val webSite: String
)