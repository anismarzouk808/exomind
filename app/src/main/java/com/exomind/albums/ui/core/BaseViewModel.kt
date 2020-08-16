package com.exomind.albums.ui.core

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
  private val subscriptions: CompositeDisposable by lazy { CompositeDisposable() }

  val navigationCommands: SingleLiveEvent<NavDirectionWrapper> by lazy { SingleLiveEvent<NavDirectionWrapper>() }

  protected fun navigate(navDirections: NavDirections, extras: FragmentNavigator.Extras? = null) {
    if (extras != null) navigationCommands.postValue(NavWithExtras(navDirections, extras))
    else navigationCommands.postValue(SimpleNav(navDirections))
  }

  private fun Disposable.autoDispose() {
    subscriptions.add(this)
  }

  override fun onCleared() {
    subscriptions.dispose()
  }


  protected fun <R> Single<R>.sub(
    onSuccess: Consumer<in R>? = Functions.emptyConsumer(),
    onError: Consumer<Throwable>? = Functions.ERROR_CONSUMER
  ) {
    async().subscribe(onSuccess, onError).autoDispose()
  }

  protected fun <R> Single<R>.sub() {
    async().subscribe().autoDispose()
  }

  private fun <T> Single<T>.async(): Single<T> {
    return subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
  }

}