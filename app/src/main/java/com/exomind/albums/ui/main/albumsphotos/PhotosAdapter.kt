package com.exomind.albums.ui.main.albumsphotos

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.exomind.albums.R
import com.exomind.albums.buisness.model.Photo
import com.exomind.albums.utils.extension.inflate

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    var items = emptyList<Photo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_album_photo))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            val photo = items[position]
            title.text = photo.title
            photoImg.load(photo.url) {
                crossfade(true)
                placeholder(R.drawable.album_cover)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title_txt)
        var photoImg: ImageView = itemView.findViewById(R.id.album_photo_img)
    }

}