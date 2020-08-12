package com.exomind.albums.ui.main.albumsphotos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exomind.albums.buisness.model.Album
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.data.datamanager.IAlbumsDataManger
import com.exomind.albums.misc.extension.setLoadingState
import com.exomind.albums.presentation.coreview.BaseViewModel
import com.exomind.albums.presentation.coreview.DataWrapper
import com.exomind.albums.presentation.coreview.Failure
import com.exomind.albums.presentation.coreview.Success
import com.exomind.albums.ui.main.users.UsersViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class AlbumPhotosViewModel @Inject constructor(private val dataManager: IAlbumsDataManger) : BaseViewModel() {
    private val _photosLiveData = MutableLiveData<DataWrapper<List<Photo>>>()
    val photosLiveData: LiveData<DataWrapper<List<Photo>>> get() = _photosLiveData


    fun loadPhotos(album: Album) {
        _photosLiveData.setLoadingState(true)
        dataManager.loadAlbumPhotos(album).sub(
            onSuccess = Consumer {
                _photosLiveData.setLoadingState(false)
                _photosLiveData.postValue(Success(it))
            },
            onError = Consumer {
                _photosLiveData.setLoadingState(false)
                _photosLiveData.postValue(Failure(UsersViewModel.UserErrorType.GET_USER_ERROR, it))
            }
        )
    }
}