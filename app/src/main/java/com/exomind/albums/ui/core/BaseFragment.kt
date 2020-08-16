package com.exomind.albums.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.exomind.albums.dagger.factory.AppViewModelFactory
import com.exomind.albums.ui.main.MainActivity
import com.exomind.albums.utils.extension.vm
import dagger.android.support.DaggerFragment
import kotlin.reflect.KClass

abstract class BaseFragment<T : BaseViewModel>(
    private val modelClass: KClass<T>,
    @LayoutRes private val layoutRes: Int
) : DaggerFragment() {

    protected val viewModel: T by lazy { vm(getAppViewModelFactory(), modelClass) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutRes, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
    }

    protected fun bindToNavigationCommands(viewModel: BaseViewModel) {
        viewModel.navigationCommands.observe(this, Observer { navDirectionsWrapper ->
            when (navDirectionsWrapper) {
                is SimpleNav -> findNavController().navigate(navDirectionsWrapper.navDirections)
                is NavWithExtras -> findNavController().navigate(
                    navDirectionsWrapper.navDirections,
                    navDirectionsWrapper.extras
                )
            }
        })
    }

    private fun getAppViewModelFactory(): AppViewModelFactory =
        (activity as BaseActivity).viewModelFactory

    fun toggleLoading(loading: Boolean) {
        if (activity is MainActivity) (activity as BaseActivity).toggleLoading(loading)
    }

    fun toggleError(show : Boolean, errorMsg : String?){
        if (activity is MainActivity) (activity as BaseActivity).toggleError(show,errorMsg)
    }

    fun setToolbarTitle(title : String, showBack : Boolean){
        if (activity is MainActivity) (activity as BaseActivity).setToolbarTitle(title,showBack)
    }
}



