package com.exomind.albums.data.persistance.mapper

import com.exomind.albums.common.listUsers
import com.exomind.albums.common.listUsersDto
import com.exomind.albums.data.network.mapper.NetworkMapper
import org.junit.Test

import org.junit.Assert.*

class DBMapperTest {

    @Test
    fun mapUsersDto() {
        val mockedUsers = listUsers
        val expected = listUsersDto
        val actual = DBMapper().mapUsersDto(mockedUsers)

        assertArrayEquals(expected.toTypedArray(),actual.toTypedArray())
    }
}