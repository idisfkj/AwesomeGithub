package com.idisfkj.awesome.common.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
fun ViewModel.request(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    handler: CoroutineExceptionHandler? = null,
    block: suspend CoroutineScope.() -> Unit
): Job = viewModelScope.launch(dispatcher) {
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        Timber.e("Http Request Exception message %s", e.message)
        withContext(Dispatchers.Main) {
            handler?.handleException(this.coroutineContext, e)
//        Timber.e("Http Request Exception code %d, message %s, response %s", e.code(), e.message(), e.response())
        }
    }
}
