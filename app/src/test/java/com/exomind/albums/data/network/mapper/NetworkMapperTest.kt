package com.exomind.albums.data.network.mapper

import com.exomind.albums.common.listUsers
import com.exomind.albums.common.listUsersDto
import org.junit.Test

import org.junit.Assert.*

class NetworkMapperTest {

    @Test
    fun mapUsers() {
        val mockedUsersDto = listUsersDto
        val expected = listUsers
        val actual = NetworkMapper().mapUsers(mockedUsersDto)

        assertArrayEquals(expected.toTypedArray(),actual.toTypedArray())
    }
}