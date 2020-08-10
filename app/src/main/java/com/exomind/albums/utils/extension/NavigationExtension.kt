package com.exomind.albums.utils.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.exomind.albums.R

fun <T> Context.openActivity(targetActivity: Class<T>, clearTask: Boolean) {
  val intent = Intent(this, targetActivity)
  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
  if (clearTask) {
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
  }
  startActivity(intent)
}

fun <T> Activity.navigateTo(targetActivity: Class<T>, clearTask: Boolean) {
  openActivity(targetActivity, clearTask)
  overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
  if (clearTask) {
    finish()
  }
}


