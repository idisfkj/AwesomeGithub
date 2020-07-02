package com.idisfkj.awesome.notification

import com.idisfkj.awesome.notification.fragment.di.NotificationFragmentComponent

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface NotificationFragmentComponentFactory {

    fun notificationFragmentComponentFactory(): NotificationFragmentComponent.Factory
}