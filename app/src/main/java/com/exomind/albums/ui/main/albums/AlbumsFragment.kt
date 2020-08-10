package com.exomind.albums.ui.main.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exomind.albums.R
import com.exomind.albums.ui.main.users.UsersViewModel
import com.exomind.albums.presentation.coreview.BaseFragment

class AlbumsFragment : BaseFragment<AlbumViewModel>(
    AlbumViewModel::class,
    R.layout.fragment_albums

){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToNavigationCommands(viewModel)
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