package com.idisfkj.awesome.componentbridge.user

import androidx.fragment.app.Fragment

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class DefaultUserBridge : UserBridgeInterface{

    override fun getUserFragment(): Fragment = Fragment()
}