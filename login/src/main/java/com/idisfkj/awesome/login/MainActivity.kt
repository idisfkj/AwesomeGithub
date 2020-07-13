package com.idisfkj.awesome.login

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.ARouterPaths
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = ARouterPaths.PATH_LOGIN_MAIN)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_main)
        findViewById<TextView>(R.id.login).setOnClickListener {
            ARouter.getInstance().build(ARouterPaths.PATH_LOGIN_LOGIN).navigation()
        }
    }
}
