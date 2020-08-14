package com.exomind.albums.ui.main.albums

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.R
import com.exomind.albums.buisness.model.Album
import com.exomind.albums.utils.extension.inflate

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {

  var itemClickListener: ((Album) -> Unit)? = null

  var items = emptyList<Album>()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.item_album))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.apply {
      val album = items[position]
      title.text = album.title

      itemView.setOnClickListener { itemClickListener?.invoke(album) }
    }
  }

  override fun getItemCount(): Int = items.size

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.title_txt)
  }

}