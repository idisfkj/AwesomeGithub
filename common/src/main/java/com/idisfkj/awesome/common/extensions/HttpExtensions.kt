package com.idisfkj.awesome.common.extensions

import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
fun <T> request(
    scope: CoroutineScope,
    callback: RequestCallback<T>?,
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    handler: CoroutineExceptionHandler? = null,
    block: suspend CoroutineScope.() -> T
): Job = scope.launch(dispatcher) {
    try {
        val result = block()
        withContext(Dispatchers.Main) {
            callback?.onSuccess(ResponseSuccess(result))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Timber.e("Http Request Exception message %s", e.message)
        withContext(Dispatchers.Main) {
            handler?.handleException(this.coroutineContext, e)
            callback?.onError(ResponseError(e))
//        Timber.e("Http Request Exception code %d, message %s, response %s", e.code(), e.message(), e.response())
        }
    }
}

interface RequestCallback<T> {
    fun onSuccess(result: ResponseSuccess<T>)
    fun onError(error: ResponseError)
}
