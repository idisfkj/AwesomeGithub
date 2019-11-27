package com.idisfkj.awesome.componentbridge.notification

import androidx.fragment.app.Fragment

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class DefaultNotificationBridge : NotificationBridgeInterface {

    override fun getNotificationFragment(): Fragment = Fragment()

}