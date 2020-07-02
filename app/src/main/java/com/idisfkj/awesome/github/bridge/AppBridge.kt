package com.idisfkj.awesome.github.bridge

import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.github.App

/**
 * App Bridge
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class AppBridge : AppBridgeInterface {

    override fun getAuthorizationBasic(): String? = App.AUTHORIZATION_BASIC

    override fun setAuthorizationBasic(authorization: String?) {
        App.AUTHORIZATION_BASIC = authorization
    }

    override fun getAccessToken(): String? = App.ACCESS_TOKEN

    override fun setAccessToken(accessToken: String?) {
        App.ACCESS_TOKEN = accessToken
    }

}