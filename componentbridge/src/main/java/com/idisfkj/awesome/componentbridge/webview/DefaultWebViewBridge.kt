package com.idisfkj.awesome.componentbridge.webview

import android.content.Context
import android.widget.Toast

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
class DefaultWebViewBridge : WebViewBridgeInterface {

    override fun toWebViewActivity(context: Context, url: String, requestUrl: String) {
        Toast.makeText(context, "toWebViewActivity: $url", Toast.LENGTH_LONG).show()
    }
}