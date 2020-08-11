package com.exomind.albums.presentation.coreview

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.exomind.albums.dagger.factory.AppViewModelFactory
import com.exomind.albums.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity(
  @LayoutRes private val layoutResId: Int
) : DaggerAppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: AppViewModelFactory

  private var loadingView: View? = null
  private var errorView: View? = null
  private var errorTxt: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutResId)
    initView()
  }

  private fun initView() {
    loadingView = findViewById(R.id.loading_view)
    errorView = findViewById(R.id.error_view)
    errorTxt = findViewById(R.id.error_txt)
  }

  fun toggleLoading(isLoading: Boolean) {
    loadingView?.visibility = if (isLoading) View.VISIBLE else View.GONE
  }

  fun showError(show : Boolean, errorMsg : String?){
    errorView?.visibility = if (show) View.VISIBLE else View.GONE
    errorTxt?.text = errorMsg ?: resources.getString(R.string.default_error_message)
  }

  fun setToolbarTitle(title : String){
    supportActionBar?.title = title
  }
}