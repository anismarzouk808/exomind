package com.exomind.albums.utils.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onTextChangedListener(listener: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(text: Editable) = Unit
        override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
            listener(text.toString())
        }
    })
}