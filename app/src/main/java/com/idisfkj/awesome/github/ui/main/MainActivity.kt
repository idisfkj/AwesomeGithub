package com.idisfkj.awesome.github.ui.main

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseDaggerActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.github.App
import com.idisfkj.awesome.github.AppComponentFactory
import com.idisfkj.awesome.github.BR
import com.idisfkj.awesome.github.R
import com.idisfkj.awesome.github.databinding.ActivityMainBinding
import com.idisfkj.awesome.github.ui.main.di.MainProviderModule
import timber.log.Timber
import kotlin.system.exitProcess

/**
 * Created by idisfkj on 2019-08-12.
 * Email : idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_APP_MAIN)
class MainActivity : BaseDaggerActivity<ActivityMainBinding, MainVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<MainVM> = MainVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AppComponentFactory).mainComponentFactory().create(MainProviderModule(this)).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return if (viewModel.exitApp()) {
                super.onKeyUp(keyCode, event)
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.press_again_to_exit_app),
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("$this: onDestroy")
        BridgeProviders.instance.clear()
        exitProcess(0)
    }

}