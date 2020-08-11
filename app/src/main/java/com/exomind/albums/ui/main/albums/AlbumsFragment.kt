package com.exomind.albums.ui.main.albums

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.R
import com.exomind.albums.presentation.coreview.BaseFragment
import com.exomind.albums.presentation.coreview.Failure
import com.exomind.albums.presentation.coreview.Loading
import com.exomind.albums.presentation.coreview.Success

class AlbumsFragment : BaseFragment<AlbumViewModel>(
    AlbumViewModel::class,
    R.layout.fragment_albums
){

    private lateinit var albumList : RecyclerView
    private val albumsAdapter by lazy{AlbumsAdapter()}
    private val args: AlbumsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToNavigationCommands(viewModel)
        setToolbarTitle(args.user.name,true)
        intiView()
        setUpRecycleView()
        observeData()
        viewModel.loadAlbums(args.user.id)
    }

    private fun intiView() {
        view?.apply { albumList = findViewById(R.id.albums_list) }
    }

    private fun setUpRecycleView(){
        albumList.layoutManager = LinearLayoutManager(context)
        val spacing = resources.getDimension(R.dimen.album_list_spacing).toInt()
        albumList.addItemDecoration(AlbumsItemDecoration(spacing))
        albumsAdapter.itemClickListener = {
            viewModel.navigateToAlbumsPhoto(it)
        }
        albumList.adapter = albumsAdapter
    }

    private fun observeData() {
        viewModel.run {
            albumsLiveData.observe(viewLifecycleOwner, Observer { dataWrapper ->
                when (dataWrapper) {
                    is Success -> {
                        albumsAdapter.items = dataWrapper.data
                        toggleError(false,null)
                    }
                    is Failure ->{
                        toggleError(true,dataWrapper.throwable?.message)
                    }

                    is Loading -> {
                        toggleLoading(dataWrapper.loading)
                        toggleError(false,null)
                    }
                }
            })
        }
    }

    class AlbumsItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.top = spaceHeight
        }
    }
}