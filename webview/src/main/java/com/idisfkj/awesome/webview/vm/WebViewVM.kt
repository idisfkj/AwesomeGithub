package com.idisfkj.awesome.webview.vm

import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
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

    override fun attach(savedInstanceState: Bundle?) {
        showLoading.value = true
    }

    fun request(requestUrl: String) {
        if (!TextUtils.isEmpty(requestUrl)) {
            request(handler = CoroutineExceptionHandler { _, _ ->
                showLoading.value = false
            }) {
                val result = repository.getNotificationRequestUrl(requestUrl)
                withContext(Dispatchers.Main) {
                    url.value = result.html_url
                    showLoading.value = false
                }
            }
        }
    }

    fun setWebViewClient() = object : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            showLoading.value = false
        }
    }

    fun setWebChromeClient() = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (newProgress > 80) showLoading.value = false
        }
    }
}