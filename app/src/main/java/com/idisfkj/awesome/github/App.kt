package com.idisfkj.awesome.github

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.BridgeInterface
import com.idisfkj.awesome.componentbridge.factory.Factory
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.followers.bridge.FollowersBridge
import com.idisfkj.awesome.following.bridge.FollowingBridge
import com.idisfkj.awesome.github.bridge.AppBridge
import com.idisfkj.awesome.github.di.DaggerAppComponent
import com.idisfkj.awesome.github.ui.main.di.MainComponent
import com.idisfkj.awesome.github.ui.welcome.di.WelcomeComponent
import com.idisfkj.awesome.home.bridge.HomeBridge
import com.idisfkj.awesome.home.fragment.di.HomeFragmentComponent
import com.idisfkj.awesome.notification.bridge.NotificationBridge
import com.idisfkj.awesome.notification.fragment.di.NotificationFragmentComponent
import com.idisfkj.awesome.repos.bridge.ReposBridge
import com.idisfkj.awesome.search.bridge.SearchBridge
import com.idisfkj.awesome.search.fragment.di.SearchFragmentComponent
import com.idisfkj.awesome.user.bridge.UserBridge
import com.idisfkj.awesome.user.fragment.di.UserFragmentComponent
import com.idisfkj.awesome.webview.bridge.WebViewBridge
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-12.
 * Email : idisfkj@gmail.com.
 */
class App : Application(), AppComponentFactory {

    companion object {
        var AUTHORIZATION_BASIC: String? = null
        var ACCESS_TOKEN: String? = null

        class CrashReportingTree : Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                    return
                }

                FakeCrashLibrary.log(priority, tag, message)

                if (t != null) {
                    if (priority == Log.ERROR) {
                        FakeCrashLibrary.logError(t)
                    } else if (priority == Log.WARN) {
                        FakeCrashLibrary.logWarning(t)
                    }
                }
            }

        }
    }

    private val appComponent by lazy { DaggerAppComponent.factory().create(this) }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CommonUtils.initApp(this)
        SPUtils.init(this)
        AUTHORIZATION_BASIC = SPUtils.getString(SPUtils.KEY_AUTHORIZATION_BASIC)
        ACCESS_TOKEN = SPUtils.getString(SPUtils.KEY_ACCESS_TOKEN)
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initRouter()
        // register bridges
        registerBridge()
        Timber.d("$this: onCreate")
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun registerBridge() {
        BridgeProviders.instance.register(AppBridge::class.java, object : Factory {
            override fun <T : BridgeInterface> create(bridgeClazz: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return AppBridge() as T
            }
        })
            .register(HomeBridge::class.java)
            .register(UserBridge::class.java)
            .register(ReposBridge::class.java)
            .register(FollowersBridge::class.java)
            .register(FollowingBridge::class.java)
            .register(NotificationBridge::class.java)
            .register(SearchBridge::class.java)
            .register(WebViewBridge::class.java)
    }

    override fun mainComponentFactory(): MainComponent.Factory = appComponent.mainComponent()

    override fun welcomeComponentFactory(): WelcomeComponent.Factory = appComponent.welcomeComponent()

    override fun userFragmentComponentFactory(): UserFragmentComponent.Factory = appComponent.userFragmentComponent()

    override fun homeFragmentComponentFactory(): HomeFragmentComponent.Factory = appComponent.homeFragmentComponent()

    override fun notificationFragmentComponentFactory(): NotificationFragmentComponent.Factory = appComponent.notificationFragmentComponent()

    override fun searchFragmentComponentFactory(): SearchFragmentComponent.Factory = appComponent.searchFragmentComponent()

}