package com.exomind.albums.ui.main.albumsphotos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exomind.albums.R
import com.exomind.albums.ui.main.users.UsersViewModel
import com.exomind.albums.presentation.coreview.BaseFragment

class AlbumPhotosFragment : BaseFragment<AlbumPhotosViewModel>(
    AlbumPhotosViewModel::class,
    R.layout.fragment_album_photos

){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiView()
        initListeners()
        observeData()
    }

    private fun intiView() {

    }

    private fun initListeners() {

    }

    private fun observeData() {

    }
}