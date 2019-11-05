package com.idisfkj.awesome.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.home.fragment.HomeFragment
import timber.log.Timber

@Route(path = "/main/main")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("========== onCreate ===========")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_main)
        addFragment()
    }

    private fun addFragment() {
        Timber.d("========== addFragment ===========")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, HomeFragment.getInstance())
            .commit()
    }
}
