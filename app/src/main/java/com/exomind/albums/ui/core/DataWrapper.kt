package com.exomind.albums.presentation.coreview

sealed class DataWrapper<out T>

data class Loading<out T>(val loading: Boolean) : DataWrapper<T>()
data class Success<out T>(val data: T) : DataWrapper<T>()
data class Failure<out T>(val errorType: ErrorType, val throwable: Throwable? = null) : DataWrapper<T>()
