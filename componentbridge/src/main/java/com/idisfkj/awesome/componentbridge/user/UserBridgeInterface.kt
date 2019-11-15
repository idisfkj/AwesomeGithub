package com.idisfkj.awesome.componentbridge.user

import androidx.fragment.app.Fragment
import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
interface UserBridgeInterface: BridgeInterface {

    fun getUserFragment(): Fragment
}