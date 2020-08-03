package com.idisfkj.awesome.github.bridge

import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.github.startup.SyncBridgeStartup

/**
 * App Bridge
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class AppBridge : AppBridgeInterface {

    override fun getAuthorizationBasic(): String? = SyncBridgeStartup.AUTHORIZATION_BASIC

    override fun setAuthorizationBasic(authorization: String?) {
        SyncBridgeStartup.AUTHORIZATION_BASIC = authorization
    }

    override fun getAccessToken(): String? = SyncBridgeStartup.ACCESS_TOKEN

    override fun setAccessToken(accessToken: String?) {
        SyncBridgeStartup.ACCESS_TOKEN = accessToken
    }

}