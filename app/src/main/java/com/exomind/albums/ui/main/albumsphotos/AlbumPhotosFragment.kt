package com.exomind.albums.ui.main.albumsphotos

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.R
import com.exomind.albums.ui.core.BaseFragment
import com.exomind.albums.ui.core.Failure
import com.exomind.albums.ui.core.Loading
import com.exomind.albums.ui.core.Success

class AlbumPhotosFragment : BaseFragment<AlbumPhotosViewModel>(
    AlbumPhotosViewModel::class,
    R.layout.fragment_album_photos
) {

    private lateinit var photosList: RecyclerView
    private val photosAdapter by lazy { AlbumPhotosAdapter() }
    private val args: AlbumPhotosFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(args.album.title, true)
        intiView()
        setUpRecyclerView()
        observeData()
        viewModel.loadPhotos(args.album)
    }

    private fun intiView() {
        view?.apply {
            photosList = findViewById(R.id.album_photos_list)
        }
    }

    private fun setUpRecyclerView() {
        photosList.layoutManager = LinearLayoutManager(context)
        val spacing = resources.getDimension(R.dimen.album_photos_list_spacing).toInt()
        photosList.addItemDecoration(AlbumPhotosItemDecoration(spacing))
        photosList.adapter = photosAdapter
    }

    private fun observeData() {
        viewModel.run {
            photosLiveData.observe(viewLifecycleOwner, Observer { dataWrapper ->
                when (dataWrapper) {
                    is Success -> {
                        photosAdapter.items = dataWrapper.data
                        toggleError(false, null)
                    }
                    is Failure -> {
                        toggleError(true, dataWrapper.throwable?.message)
                    }

                    is Loading -> {
                        toggleLoading(dataWrapper.loading)
                        toggleError(false, null)
                    }
                }
            })
        }
    }

    class AlbumPhotosItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.top = spaceHeight
        }
    }
}