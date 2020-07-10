package com.idisfkj.awesome.notification.fragment

import com.idisfkj.awesome.basic.fragment.BaseHiltFragment
import com.idisfkj.awesome.notification.BR
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.databinding.NotifyFragmentNotificationLayoutBinding
import com.idisfkj.awesome.notification.vm.NotificationVM
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
@AndroidEntryPoint
class NotificationFragment :
    BaseHiltFragment<NotifyFragmentNotificationLayoutBinding, NotificationVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.notify_fragment_notification_layout

    override fun getViewModelClass(): Class<NotificationVM> = NotificationVM::class.java

    companion object {
        fun getInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }
}