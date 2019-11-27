package com.idisfkj.awesome.notification.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.live.SingleLiveEvent

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationVM : BaseVM() {

    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
    }

    fun createAdapter() = null

    fun onRefreshListener() {
        isRefreshing.value = true
    }

}