package com.exomind.albums.ui.main.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exomind.albums.buisness.model.User
import com.exomind.albums.data.datamanager.IAlbumsDataManger
import com.exomind.albums.ui.core.*
import com.exomind.albums.utils.extension.setLoadingState
import io.reactivex.functions.Consumer
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val dataManager: IAlbumsDataManger) : BaseViewModel(){

    private val _usersLiveData = MutableLiveData<DataWrapper<List<User>>>()
    val usersLiveData: LiveData<DataWrapper<List<User>>> get() = _usersLiveData

    private var users  : List<User>  = emptyList()


    fun loadUsers(){
        _usersLiveData.setLoadingState(true)
        dataManager.loadUsers().sub(
            onSuccess = Consumer {
                dataManager.insertUsers(it).sub()
                _usersLiveData.setLoadingState(false)
                _usersLiveData.postValue(Success(it))
                users = it
            },
            onError = Consumer {
                _usersLiveData.setLoadingState(false)
                _usersLiveData.postValue(Failure(UserErrorType.GET_USER_ERROR,it))
            }
        )
    }

    fun filterUsers( searchText : String) : List<User>{
        return users.filter {
            it.name.contains(searchText,true)
                    || it.email.contains(searchText,true)
                    || it.phone.contains(searchText,true)
                    ||it.pseudo.contains(searchText,true)
        }
    }

    fun navigateToAlbums(user : User){
        navigate(UsersFragmentDirections.actionUsersFragmentToAlbumsFragment(user))
    }

    enum class UserErrorType : ErrorType {
        GET_USER_ERROR
    }

}
