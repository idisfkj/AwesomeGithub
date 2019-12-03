package com.idisfkj.awesome.webview.bridge

import android.content.Context
import androidx.core.os.bundleOf
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
class WebViewBridge : WebViewBridgeInterface {

    override fun toWebViewActivity(context: Context, url: String, requestUrl: String) {
        ARouter.getInstance().build(ARouterPaths.PATH_WEBVIEW_WEBVIEW).with(
            bundleOf("url" to url, "requestUrl" to requestUrl)
        ).navigation(context)
    }

}