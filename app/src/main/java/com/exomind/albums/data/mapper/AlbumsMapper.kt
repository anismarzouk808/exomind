package com.exomind.albums.data.mapper

import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.model.UserDto

class AlbumsMapper{
    fun MapUser(userDto: UserDto) : User{
        return with(userDto){
            User(
                id = id ?:0,
                name = name ?:String(),
                email = email ?: String(),
                phone = phone ?: String(),
                pseudo = pseudo?: String(),
                webSite = webSite ?: String()
            )
        }
    }

    fun mapListUsers(usersDto : List<UserDto>) : List<User>{
        return usersDto.map { MapUser(it)}
    }

    /**
     * filter list of users returned by user
     * return only the users wich have Id not null and name not null
     */
    fun filterUsersDto(usersDto : List<UserDto>) :  List<UserDto> {
        return usersDto.filter { it.id !=null && it.name != null }
    }
}

