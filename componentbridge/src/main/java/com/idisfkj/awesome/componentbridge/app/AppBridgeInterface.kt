package com.idisfkj.awesome.componentbridge.app

import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
interface AppBridgeInterface: BridgeInterface {

    /**
     * 获取用户的Authorization Basic
     */
    fun getAuthorizationBasic(): String?

    fun setAuthorizationBasic(authorization: String?)

    /**
     * 获取用户的AccessToken
     */
    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)
}