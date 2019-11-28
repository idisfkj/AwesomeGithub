package com.idisfkj.awesome.notification.vm

import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.NotificationModel

/**
 * Created by idisfkj on 2019-11-28.
 * Email : idisfkj@gmail.com.
 */
class NotificationVHVM : BaseRecyclerVM<NotificationModel>() {

    var data: NotificationModel? = null

    override fun onBind(model: NotificationModel?) {
        data = model
    }
}