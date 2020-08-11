package com.exomind.albums.ui.main.users

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.R
import com.exomind.albums.utils.extension.onTextChangedListener
import com.exomind.albums.presentation.coreview.BaseFragment
import com.exomind.albums.presentation.coreview.Failure
import com.exomind.albums.presentation.coreview.Loading
import com.exomind.albums.presentation.coreview.Success

class UsersFragment : BaseFragment<UsersViewModel>(
    UsersViewModel::class,
    R.layout.fragment_users){

    private lateinit var userList : RecyclerView
    private lateinit var searchBarUser : EditText
    private val usersAdapter by lazy { UsersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToNavigationCommands(viewModel)
        setToolbarTitle(resources.getString(R.string.users_title))
        intiView()
        setUpRecyclerView()
        initListeners()
        observeData()
        viewModel.loadUsers()
    }

    private fun intiView() {
        view?.apply {
            userList = findViewById(R.id.users_list)
            searchBarUser = findViewById(R.id.search_bar_edtx)
        }
    }

    private fun setUpRecyclerView(){
        userList.layoutManager = LinearLayoutManager(context)
        usersAdapter.itemClickListener = {
            viewModel.navigateToAlbums(it.id)
        }
        userList.adapter = usersAdapter
    }

    private fun initListeners() {
        searchBarUser.onTextChangedListener {
            usersAdapter.filteredItems = viewModel.filterUsers(it)
        }
    }

    private fun observeData() {
        viewModel.run {
            usersLiveData.observe(viewLifecycleOwner, Observer { dataWrapper ->
                when (dataWrapper) {
                    is Success -> {
                        usersAdapter.items = dataWrapper.data
                        showError(false,null)
                    }
                    is Failure ->{
                       showError(true,dataWrapper.throwable?.message)
                        println("errrrrrrorrrr === ${dataWrapper.throwable?.message}")
                    }

                    is Loading -> {
                        toggleLoading(dataWrapper.loading)
                        showError(false,null)
                    }
                }
            })
        }
    }
}