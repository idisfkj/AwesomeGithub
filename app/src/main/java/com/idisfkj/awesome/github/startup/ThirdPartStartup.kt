package com.idisfkj.awesome.github.startup

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.github.BuildConfig
import com.idisfkj.awesome.github.FakeCrashLibrary
import com.rousetime.android_startup.AndroidStartup
import timber.log.Timber

/**
 * Created by idisfkj on 2020/8/3.
 * Email: idisfkj@gmail.com.
 */
class ThirdPartStartup : AndroidStartup<Void>() {

    override fun callCreateOnMainThread(): Boolean = false

    override fun waitOnMainThread(): Boolean = false

    override fun create(context: Context): Void? {
        (context as? Application)?.let {
            SPUtils.init(it)
            CommonUtils.initApp(it)
            initRouter(it)
        }
        initTimber()
        return null
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    private fun initRouter(app: Application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(app)
    }

    internal class CrashReportingTree : Timber.Tree() {
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