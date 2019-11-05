package com.idisfkj.awesome.componentbridge.home

import androidx.fragment.app.Fragment
import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
interface HomeBridgeInterface: BridgeInterface {

    fun getHomeFragment(): Fragment
}