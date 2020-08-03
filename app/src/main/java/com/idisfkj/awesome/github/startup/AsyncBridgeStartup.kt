package com.idisfkj.awesome.github.startup

import android.content.Context
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.followers.bridge.FollowersBridge
import com.idisfkj.awesome.following.bridge.FollowingBridge
import com.idisfkj.awesome.webview.bridge.WebViewBridge
import com.rousetime.android_startup.AndroidStartup

/**
 * non first-level page bridge initialize, so can executor on other thread.
 * Created by idisfkj on 2020/8/3.
 * Email: idisfkj@gmail.com.
 */
class AsyncBridgeStartup : AndroidStartup<Void>() {

    override fun callCreateOnMainThread(): Boolean = false

    override fun waitOnMainThread(): Boolean = false

    override fun create(context: Context): Void? {
        registerBridge()
        return null
    }

    private fun registerBridge() {
        BridgeProviders.instance
            .register(FollowersBridge::class.java)
            .register(FollowingBridge::class.java)
            .register(WebViewBridge::class.java)
    }

}