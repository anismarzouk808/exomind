package com.exomind.albums.data.persistance.mapper

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto

class DBMapper {

    /***map users ***/
    private fun mapUserDto(user: User): UserDto {
        return with(user) {
            UserDto(
                id = id,
                name = name ,
                email = email,
                phone = phone ,
                pseudo = pseudo ,
                webSite = webSite
            )
        }
    }

    fun mapUsersDto(users: List<User>): List<UserDto> {
        return users.map { mapUserDto(it) }
    }

    /***map users ***/

    /***map albums ***/

    private fun mapAlbumDto(album: Album): AlbumDto {
        return with(album) {
            AlbumDto(
                id = id ,
                userId = userId ,
                title = title
            )
        }
    }

    fun mapAlbumsDto(albums: List<Album>): List<AlbumDto> {
        return albums.map { mapAlbumDto(it) }
    }


    /***map albums ***/


    /***map album photos ***/

    private fun mapPhotoDto(photo: Photo): PhotoDto {
        return with(photo) {
            PhotoDto(
                id = id ,
                albumId = albumId,
                title = title,
                url = url ,
                thumbnailUrl = thumbnailUrl
            )
        }
    }

    fun mapPhotosDto(photosDto: List<Photo>): List<PhotoDto> {
        return photosDto.map { mapPhotoDto(it) }
    }


    /***map album photos ***/

}

