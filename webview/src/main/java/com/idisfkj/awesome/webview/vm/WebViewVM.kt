package com.idisfkj.awesome.webview.vm

import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.webview.repository.WebViewRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
class WebViewVM(private val repository: WebViewRepository) : BaseVM() {

    val url = MutableLiveData<String>()

    override fun attach(savedInstanceState: Bundle?) {}

    fun request(requestUrl: String) {
        if (!TextUtils.isEmpty(requestUrl)) {
            showLoading.value = true
            request(handler = CoroutineExceptionHandler { _, _ ->
                showLoading.value = false
            }) {
                val result = repository.getNotificationRequestUrl(requestUrl)
                withContext(Dispatchers.Main) {
                    showLoading.value = false
                    url.value = result.html_url
                }
            }
        }
    }
}