package com.exomind.albums.utils.extension

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions
import io.reactivex.schedulers.Schedulers

fun Completable.sub(
  onComplete: Action? = Functions.EMPTY_ACTION,
  onError: Consumer<in Throwable>?
): Disposable {
  return async().subscribe(onComplete, onError)
}

private fun Completable.async(): Completable {
  return subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
}