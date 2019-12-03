package com.idisfkj.awesome.componentbridge.webview

import android.content.Context
import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
interface WebViewBridgeInterface : BridgeInterface {

    fun toWebViewActivity(context: Context, url: String = "", requestUrl: String = "")

}