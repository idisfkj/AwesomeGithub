package com.idisfkj.awesome.notification.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewVH
import com.idisfkj.awesome.basic.recyclerview.CommonRecyclerViewVH
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.notification.BR
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.vm.NotificationVHVM

/**
 * Created by idisfkj on 2019-11-28.
 * Email : idisfkj@gmail.com.
 */
class NotificationAdapter : BaseRecyclerViewAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return CommonRecyclerViewVH(
            parent,
            R.layout.notify_item_notification_layout,
            NotificationVHVM(),
            BR.vm
        )
    }
}