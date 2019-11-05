package com.idisfkj.awesome.componentbridge.app

/**
 * app bridge default implement
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class DefaultAppBridge : AppBridgeInterface {

    override fun getAuthorizationBasic(): String? = ""

    override fun setAuthorizationBasic(authorization: String?) {

    }

    override fun getAccessToken(): String? = "2db4feafada84416d4c4d75cf667d8d126286c5d"

    override fun setAccessToken(accessToken: String?) {

    }
}