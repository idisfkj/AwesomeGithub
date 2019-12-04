package com.idisfkj.awesome.webview.vm

import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.navigation.OnNavigationListener
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
    val backClick = SingleLiveEvent<Boolean>()

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
            if (newProgress >= 100) showLoading.value = false
        }
    }

    fun setOnNavigationListener() = object : OnNavigationListener {

        override fun onBackClick() {
            backClick.value = true
        }

        override fun onRightIconClick() {}
    }
}