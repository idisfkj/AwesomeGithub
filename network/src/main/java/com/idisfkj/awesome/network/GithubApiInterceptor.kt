package com.idisfkj.awesome.network

import android.text.TextUtils
import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val appBridge =
            BridgeProviders.instance.getBridge(AppBridgeInterface::class.java)
        Timber.d("intercept url %s %s %s", request.url(), appBridge.getAuthorizationBasic(), appBridge.getAccessToken())

        val builder = request.newBuilder()
        val authorization =
            if (!TextUtils.isEmpty(appBridge.getAuthorizationBasic())) "Basic " + appBridge.getAuthorizationBasic()
            else "token " + appBridge.getAccessToken()
        builder.addHeader("Authorization", authorization)
        val response = chain.proceed(builder.build())
        Timber.d("intercept url %s, response %s ,code %d", request.url(), response.body().toString(), response.code())
        return response
    }
}
