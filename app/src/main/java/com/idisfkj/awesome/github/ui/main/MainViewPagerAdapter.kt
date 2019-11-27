package com.idisfkj.awesome.github.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.idisfkj.awesome.componentbridge.home.HomeBridgeInterface
import com.idisfkj.awesome.componentbridge.notification.NotificationBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.user.UserBridgeInterface

/**
 * Created by idisfkj on 2019-08-16.
 * Email : idisfkj@gmail.com.
 */
class MainViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> BridgeProviders.instance.getBridge(HomeBridgeInterface::class.java).getHomeFragment()
        1 -> BridgeProviders.instance.getBridge(NotificationBridgeInterface::class.java)
            .getNotificationFragment()
        else -> BridgeProviders.instance.getBridge(UserBridgeInterface::class.java).getUserFragment()
    }

    override fun getCount(): Int = 3
}