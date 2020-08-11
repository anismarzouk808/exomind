package com.exomind.albums.ui.main.users

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.R
import com.exomind.albums.buisness.model.User

import com.exomind.albums.misc.extension.inflate

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

  var itemClickListener: ((User) -> Unit)? = null

  var items = emptyList<User>()
    set(value) {
      field = value
      filteredItems = value
      notifyDataSetChanged()
    }

  var filteredItems = emptyList<User>()
  set(value) {
    field = value
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.item_user))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.apply {
      val user = filteredItems[position]
      name.text = user.name
      email.text = user.email
      pseudo.text = user.pseudo
      webSite.text = user.webSite
      phone.text = user.phone

      itemView.setOnClickListener { itemClickListener?.invoke(user) }
    }
  }

  override fun getItemCount(): Int = filteredItems.size

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name_txt)
    var pseudo: TextView = itemView.findViewById(R.id.pseudo_txt)
    var phone: TextView = itemView.findViewById(R.id.phone_txt)
    var email: TextView = itemView.findViewById(R.id.email_txt)
    var webSite: TextView = itemView.findViewById(R.id.website_txt)
  }

}