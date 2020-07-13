package com.idisfkj.awesome.webview.vm

import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.NotificationRequestUrlModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.navigation.OnNavigationListener
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.webview.repository.WebViewRepository

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
class WebViewVM @ViewModelInject constructor(
    private val repository: WebViewRepository
): BaseVM() {

    val url = MutableLiveData<String>()
    val backClick = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        showLoading.value = true
    }

    fun request(requestUrl: String) {
        if (!TextUtils.isEmpty(requestUrl)) {
            repository.getNotificationRequestUrl(
                viewModelScope,
                requestUrl,
                object : RequestCallback<NotificationRequestUrlModel> {
                    override fun onSuccess(result: ResponseSuccess<NotificationRequestUrlModel>) {
                        url.value = result.data?.html_url
                    }

                    override fun onError(error: ResponseError) {
                        showLoading.value = false
                    }

                })
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