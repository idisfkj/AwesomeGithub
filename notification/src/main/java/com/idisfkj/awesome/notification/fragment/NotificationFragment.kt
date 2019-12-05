package com.idisfkj.awesome.notification.fragment

import com.idisfkj.awesome.basic.fragment.BaseFragment
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.notification.BR
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.databinding.NotifyFragmentNotificationLayoutBinding
import com.idisfkj.awesome.notification.repository.NotificationRepository
import com.idisfkj.awesome.notification.vm.NotificationVM

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationFragment :
    BaseFragment<NotifyFragmentNotificationLayoutBinding, NotificationVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.notify_fragment_notification_layout

    override fun getViewModelInstance(): NotificationVM =
        NotificationVM(NotificationRepository(HttpClient.getService()), lifecycle)

    override fun getViewModelClass(): Class<NotificationVM> = NotificationVM::class.java

    companion object {
        fun getInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }
}