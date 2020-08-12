package com.exomind.albums.ui.main

import android.os.Bundle
import com.exomind.albums.R
import com.exomind.albums.presentation.coreview.BaseActivity

class MainActivity : BaseActivity(R.layout.main_activity){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
