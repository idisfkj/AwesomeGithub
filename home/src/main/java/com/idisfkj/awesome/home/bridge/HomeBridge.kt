package com.idisfkj.awesome.home.bridge

import androidx.fragment.app.Fragment
import com.idisfkj.awesome.componentbridge.home.HomeBridgeInterface
import com.idisfkj.awesome.home.fragment.HomeFragment

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeBridge : HomeBridgeInterface {

    override fun getHomeFragment(): Fragment {
        return HomeFragment.getInstance()
    }
}