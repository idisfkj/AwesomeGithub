package com.idisfkj.awesome.github.startup

import android.content.Context
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.BridgeInterface
import com.idisfkj.awesome.componentbridge.factory.Factory
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.github.bridge.AppBridge
import com.idisfkj.awesome.notification.bridge.NotificationBridge
import com.idisfkj.awesome.repos.bridge.ReposBridge
import com.idisfkj.awesome.search.bridge.SearchBridge
import com.idisfkj.awesome.user.bridge.UserBridge
import com.rousetime.android_startup.AndroidStartup
import com.rousetime.android_startup.Startup

/**
 * first-level page bridge initialize, so need execute on main thread.
 * Created by idisfkj on 2020/8/3.
 * Email: idisfkj@gmail.com.
 */
class SyncBridgeStartup : AndroidStartup<Void>() {

    companion object {
        var AUTHORIZATION_BASIC: String? = null
        var ACCESS_TOKEN: String? = null
    }

    override fun callCreateOnMainThread(): Boolean = true

    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context): Void? {
        AUTHORIZATION_BASIC = SPUtils.getString(SPUtils.KEY_AUTHORIZATION_BASIC)
        ACCESS_TOKEN = SPUtils.getString(SPUtils.KEY_ACCESS_TOKEN)
        registerBridge()

        return null
    }

    override fun dependencies(): List<Class<out Startup<*>>>? {
        return listOf(UtilsStartup::class.java)
    }

    private fun registerBridge() {
        BridgeProviders.instance.register(AppBridge::class.java, object : Factory {
            override fun <T : BridgeInterface> create(bridgeClazz: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return AppBridge() as T
            }
        })
            .register(SearchBridge::class.java)
            .register(NotificationBridge::class.java)
            .register(UserBridge::class.java)
            .register(ReposBridge::class.java)
    }

}