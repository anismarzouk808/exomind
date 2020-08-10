package com.transdev.mobime.presentation.coreview

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.amneils.bostagi.dagger.factory.AppViewModelFactory
import com.exomind.albums.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity(
  @LayoutRes private val layoutResId: Int
) : DaggerAppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: AppViewModelFactory

  private var loadingView: View? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutResId)
    initView()
  }

  private fun initView() {
    loadingView = findViewById(R.id.loading_view)
  }

  fun toggleLoading(isLoading: Boolean) {
    loadingView?.visibility = if (isLoading) View.VISIBLE else View.GONE
  }
}