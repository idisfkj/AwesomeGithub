package com.idisfkj.awesome.following

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.app.DefaultAppBridge
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.DefaultWebViewBridge
import com.idisfkj.awesome.following.di.DaggerAppComponent
import com.idisfkj.awesome.following.di.FollowingComponent
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingApp : Application(), FollowingComponentFactory {

    override fun onCreate() {
        super.onCreate()
        SPUtils.init(this)
        initTimber()
        initRouter()
        // register bridges
        BridgeProviders.instance.register(DefaultAppBridge::class.java)
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

    override fun followingComponentFactory(): FollowingComponent.Factory = DaggerAppComponent.factory().create(this).followingComponent()

}