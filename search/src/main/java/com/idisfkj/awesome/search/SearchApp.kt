package com.idisfkj.awesome.search

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.app.DefaultAppBridge
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.DefaultWebViewBridge
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface
import com.idisfkj.awesome.repos.bridge.ReposBridge
import com.idisfkj.awesome.search.di.DaggerAppComponent
import com.idisfkj.awesome.search.fragment.di.SearchFragmentComponent
import timber.log.Timber

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
class SearchApp : Application(), SearchFragmentComponentFactory {

    override fun onCreate() {
        super.onCreate()
        SPUtils.init(this)
        initTimber()
        initRouter()
        // register bridges
        BridgeProviders.instance.register(DefaultAppBridge::class.java)
            .register(ReposBridge::class.java)
            .register(DefaultWebViewBridge::class.java)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun searchFragmentComponentFactory(): SearchFragmentComponent.Factory =
        DaggerAppComponent.factory().create(this).searchFragmentComponent()
}