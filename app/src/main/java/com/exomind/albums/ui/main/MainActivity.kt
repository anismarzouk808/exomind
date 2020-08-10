package com.exomind.albums.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.exomind.albums.R
import com.transdev.mobime.misc.extension.vm
import com.transdev.mobime.presentation.coreview.*

class MainActivity : BaseActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
