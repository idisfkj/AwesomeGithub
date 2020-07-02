package com.idisfkj.awesome.notification.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.idisfkj.awesome.basic.fragment.BaseDaggerFragment
import com.idisfkj.awesome.notification.BR
import com.idisfkj.awesome.notification.NotificationFragmentComponentFactory
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.databinding.NotifyFragmentNotificationLayoutBinding
import com.idisfkj.awesome.notification.fragment.di.NotificationFragmentProviderModule
import com.idisfkj.awesome.notification.vm.NotificationVM

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationFragment :
    BaseDaggerFragment<NotifyFragmentNotificationLayoutBinding, NotificationVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.notify_fragment_notification_layout

    override fun getViewModelClass(): Class<NotificationVM> = NotificationVM::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity().application as NotificationFragmentComponentFactory).notificationFragmentComponentFactory()
            .create(NotificationFragmentProviderModule(lifecycle, lifecycleScope)).inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun getInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }
}