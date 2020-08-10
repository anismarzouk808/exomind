package com.exomind.albums.ui.splash

import androidx.lifecycle.LiveData
import com.transdev.mobime.presentation.coreview.BaseViewModel
import com.transdev.mobime.presentation.coreview.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel  @Inject constructor(): BaseViewModel(){


    private val _singleLiveData = SingleLiveEvent<Navigation>()
    val singleLiveData: LiveData<Navigation> get() = _singleLiveData

    fun startTimer() {
        Single.timer(SPLASH_DURATION, TimeUnit.MILLISECONDS).sub(Consumer {
            _singleLiveData.postValue(Navigation.TO_MAIN)
        })
    }

    companion object {
        const val SPLASH_DURATION = 3000L
    }

    enum class Navigation {
        TO_MAIN
    }
}