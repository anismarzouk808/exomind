package com.exomind.albums.ui.main.users

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.exomind.albums.R
import com.transdev.mobime.presentation.coreview.BaseFragment

class UsersFragment : BaseFragment<UsersViewModel>(
    UsersViewModel::class,
    R.layout.fragment_users

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