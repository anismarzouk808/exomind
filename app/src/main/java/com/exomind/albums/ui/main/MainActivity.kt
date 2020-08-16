package com.exomind.albums.ui.main

import com.exomind.albums.R
import com.exomind.albums.ui.core.BaseActivity

class MainActivity : BaseActivity(R.layout.main_activity) {
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
