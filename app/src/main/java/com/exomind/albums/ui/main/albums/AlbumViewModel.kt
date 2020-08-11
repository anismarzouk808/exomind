package com.exomind.albums.ui.main.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exomind.albums.buisness.model.Album
import com.exomind.albums.data.datamanager.IAlbumsDataManger
import com.exomind.albums.misc.extension.setLoadingState
import com.exomind.albums.presentation.coreview.BaseViewModel
import com.exomind.albums.presentation.coreview.DataWrapper
import com.exomind.albums.presentation.coreview.Failure
import com.exomind.albums.presentation.coreview.Success
import com.exomind.albums.ui.main.users.UsersViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class AlbumViewModel @Inject constructor(private val dataManager: IAlbumsDataManger) :
    BaseViewModel() {

    private val _albumsLiveData = MutableLiveData<DataWrapper<List<Album>>>()
    val albumsLiveData: LiveData<DataWrapper<List<Album>>> get() = _albumsLiveData


    fun loadAlbums(userId: Int) {
        _albumsLiveData.setLoadingState(true)
        dataManager.loadAlbums(userId).sub(
            onSuccess = Consumer {
                _albumsLiveData.setLoadingState(false)
                _albumsLiveData.postValue(Success(it))
            },
            onError = Consumer {
                _albumsLiveData.setLoadingState(false)
                _albumsLiveData.postValue(Failure(UsersViewModel.UserErrorType.GET_USER_ERROR, it))
            }
        )
    }

    fun navigateToAlbumsPhoto(album : Album){
        navigate(AlbumsFragmentDirections.actionAlbumsFragmentToAlbumPhotosFragment(album))
    }
}