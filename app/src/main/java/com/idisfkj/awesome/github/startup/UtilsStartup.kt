package com.idisfkj.awesome.github.startup

import android.app.Application
import android.content.Context
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import com.rousetime.android_startup.AndroidStartup

/**
 * Created by idisfkj on 2020/8/3.
 * Email: idisfkj@gmail.com.
 */
class UtilsStartup : AndroidStartup<Void>() {

    override fun callCreateOnMainThread(): Boolean = true

    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context): Void? {
        (context as? Application)?.let {
            SPUtils.init(it)
            CommonUtils.initApp(it)
        }

        return null
    }

}