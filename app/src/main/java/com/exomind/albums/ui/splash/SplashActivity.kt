package com.exomind.albums.ui.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import com.exomind.albums.R
import com.exomind.albums.ui.main.MainActivity
import com.exomind.albums.utils.extension.navigateTo
import com.exomind.albums.misc.extension.vm
import com.exomind.albums.presentation.coreview.BaseActivity

class SplashActivity : BaseActivity(R.layout.splash_activity){
    private val viewModel by lazy { vm(viewModelFactory, SplashViewModel::class) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        observeLiveData()
    }

    override fun onStart() {
        super.onStart()
        viewModel.startTimer()
    }

    private fun observeLiveData() {
        viewModel.run {
            singleLiveData.observe(this@SplashActivity, Observer {
                navigateTo(MainActivity::class.java, true)
            })
        }
    }
}