package com.idisfkj.awesome.webview

import com.idisfkj.awesome.webview.di.WebViewComponent

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
interface WebViewComponentFactory {

    fun webviewComponentFactory(): WebViewComponent.Factory
}