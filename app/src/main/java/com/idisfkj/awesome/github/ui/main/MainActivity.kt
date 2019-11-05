package com.idisfkj.awesome.github.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.provider.BridgeProvider
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.github.BR
import com.idisfkj.awesome.github.R
import com.idisfkj.awesome.github.databinding.ActivityMainBinding
import timber.log.Timber
import kotlin.system.exitProcess

/**
 * Created by idisfkj on 2019-08-12.
 * Email : idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_APP_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelInstance(): MainVM =
        MainVM(application, supportFragmentManager)

    override fun getViewModelClass(): Class<MainVM> = MainVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObserver()
    }

    private fun addObserver() {

    }

    companion object {

        fun goToPage(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("$this: onDestroy")
        BridgeProviders.instance.clear()
        exitProcess(0)
    }

}