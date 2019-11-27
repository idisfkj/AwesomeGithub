package com.idisfkj.awesome.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.notification.fragment.NotificationFragment

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_NOTIFICATION_MAIN)
class NotificationMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notify_activity_main_layout)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, NotificationFragment.getInstance())
            .commit()
    }
}