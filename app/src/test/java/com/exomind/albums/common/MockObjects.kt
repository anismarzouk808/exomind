package com.exomind.albums.common

import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.model.UserDto

val userDto = UserDto(
    1,
    "Anis",
    "anis",
    "anis@gmail.com",
    "062757",
    "anis.com"
)

val listUsersDto = listOf(userDto, userDto, userDto)

val user = User(
    1,
    "Anis",
    "anis",
    "anis@gmail.com",
    "062757",
    "anis.com"
)

val listUsers = listOf(user, user, user)