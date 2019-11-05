package com.idisfkj.awesome.common.extensions

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
inline fun createTextWatcher(
    crossinline afterTextChanged: (s: Editable?) -> Unit = {},
    crossinline beforeTextChanged: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit = { _, _, _, _ -> },
    crossinline onTextChanged: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit = { _, _, _, _ -> }
) = object : TextWatcher {

    override fun afterTextChanged(s: Editable?) {
        afterTextChanged(s)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeTextChanged(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onTextChanged(s, start, before, count)
    }

}

