package com.exomind.albums.misc.extension

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.exomind.albums.presentation.coreview.DataWrapper
import com.exomind.albums.presentation.coreview.Loading


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <T> MutableLiveData<DataWrapper<T>>.setLoadingState(loading: Boolean) {
  this.value = Loading(loading)
}

fun RecyclerView.ViewHolder.getContext() = itemView.context

fun Activity.hideKeyboard(): Boolean {
  val view = currentFocus
  view?.let {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
  }
  return false
}