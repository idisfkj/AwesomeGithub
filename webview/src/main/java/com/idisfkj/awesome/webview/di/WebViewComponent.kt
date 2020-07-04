package com.idisfkj.awesome.webview.di

import com.idisfkj.awesome.webview.WebViewActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [WebViewModule::class, WebViewProviderModule::class])
interface WebViewComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: WebViewProviderModule): WebViewComponent
    }

    fun inject(webViewActivity: WebViewActivity)

}
