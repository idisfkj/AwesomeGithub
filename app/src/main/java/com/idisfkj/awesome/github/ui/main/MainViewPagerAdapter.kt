package com.idisfkj.awesome.github.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.idisfkj.awesome.componentbridge.home.HomeBridgeInterface
import com.idisfkj.awesome.componentbridge.notification.NotificationBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.search.SearchBridgeInterface
import com.idisfkj.awesome.componentbridge.user.UserBridgeInterface
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-08-16.
 * Email : idisfkj@gmail.com.
 */
class MainViewPagerAdapter @Inject constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> BridgeProviders.instance.getBridge(SearchBridgeInterface::class.java).getSearchFragment()
        1 -> BridgeProviders.instance.getBridge(NotificationBridgeInterface::class.java)
            .getNotificationFragment()
        else -> BridgeProviders.instance.getBridge(UserBridgeInterface::class.java).getUserFragment()
    }

    override fun getCount(): Int = 3
}