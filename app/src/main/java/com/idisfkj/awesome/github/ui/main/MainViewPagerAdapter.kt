package com.idisfkj.awesome.github.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.idisfkj.awesome.componentbridge.home.HomeBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders

/**
 * Created by idisfkj on 2019-08-16.
 * Email : idisfkj@gmail.com.
 */
class MainViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return BridgeProviders.instance.getBridge(HomeBridgeInterface::class.java).getHomeFragment()
    }

    override fun getCount(): Int = 3
}