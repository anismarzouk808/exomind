package com.exomind.albums.data.network.mapper

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto

class NetworkMapper {

    /***map users ***/
    private fun mapUser(userDto: UserDto): User {
        return with(userDto) {
            User(
                id = id ?: 0,
                name = name ?: String(),
                email = email ?: String(),
                phone = phone ?: String(),
                pseudo = pseudo ?: String(),
                webSite = webSite ?: String()
            )
        }
    }

    fun mapUsers(usersDto: List<UserDto>): List<User> {
        return usersDto.filter { it.id != null && it.name != null }.map { mapUser(it) }
    }

    /***map users ***/

    /***map albums ***/

    private fun mapAlbum(albumDto: AlbumDto): Album {
        return with(albumDto) {
            Album(
                id = id ?: 0,
                userId = userId ?: 0,
                title = title ?: String()
            )
        }
    }

    fun mapAlbums(albumsDto: List<AlbumDto>): List<Album> {
        return albumsDto.filter { it.id != null && !it.title.isNullOrEmpty() }.map { mapAlbum(it) }
    }


    /***map albums ***/


    /***map album photos ***/

    private fun mapAlbumPhoto(photoDto: PhotoDto): Photo {
        return with(photoDto) {
            Photo(
                id = id ?: 0,
                albumId = albumId ?: 0,
                title = title ?: String(),
                url = url ?: String(),
                thumbnailUrl = thumbnailUrl ?: String()
            )
        }
    }

    fun mapAlbumPhoto(photosDto: List<PhotoDto>): List<Photo> {
        return photosDto.filter { it.url != null && !it.title.isNullOrEmpty() }.map { mapAlbumPhoto(it) }
    }


    /***map album photos ***/

}

