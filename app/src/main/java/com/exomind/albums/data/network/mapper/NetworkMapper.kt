package com.exomind.albums.data.network.mapper

import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.model.AlbumDto
import com.exomind.albums.data.model.PhotoDto
import com.exomind.albums.data.model.UserDto

class NetworkMapper {

    /***map users ***/
    /**
     * map  [UserDto] into [User]
     * @param userDto the userDto to Map
     */
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

    /**
     * map list of [UserDto] into a list of [User]
     * ignore the usersDto with id null or name null
     * @param usersDto list of usersDto to map
     */
    fun mapUsers(usersDto: List<UserDto>): List<User> {
        return usersDto.filter { it.id != null || it.name != null }.map { mapUser(it) }
    }

    /***map users ***/

    /***map albums ***/

    /**
     * map [AlbumDto] into [Album]
     * @param albumDto albumDto to map
     */
    private fun mapAlbum(albumDto: AlbumDto): Album {
        return with(albumDto) {
            Album(
                id = id ?: 0,
                userId = userId ?: 0,
                title = title ?: String()
            )
        }
    }

    /**
     * map list of [AlbumDto] into list of [Album]
     * @param albumsDto : list of albumDto to map
     */
    fun mapAlbums(albumsDto: List<AlbumDto>): List<Album> {
        return albumsDto.filter { it.id != null && !it.title.isNullOrEmpty() }.map { mapAlbum(it) }
    }


    /***map albums ***/


    /***map album photos ***/

    /**
     * map [PhotoDto] into [Photo]
     * @param photoDto : the photoDto to map
     */
    private fun mapPhoto(photoDto: PhotoDto): Photo {
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

    /**
     * map list of [PhotoDto] into list of [Photo]
     * @param albumsDto : list of photoDto to map
     */
    fun mapPhotos(photosDto: List<PhotoDto>): List<Photo> {
        return photosDto.filter { it.url != null && !it.title.isNullOrEmpty() }.map { mapPhoto(it) }
    }


    /***map album photos ***/

}

