package com.idisfkj.awesome.github

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.BridgeInterface
import com.idisfkj.awesome.componentbridge.factory.Factory
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.github.bridge.AppBridge
import com.idisfkj.awesome.home.bridge.HomeBridge
import com.idisfkj.awesome.repos.bridge.ReposBridge
import com.idisfkj.awesome.user.bridge.UserBridge
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-12.
 * Email : idisfkj@gmail.com.
 */
class App : Application() {

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

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
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
    }
}