package com.idisfkj.awesome.notification.vm

import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.notification.R

/**
 * Created by idisfkj on 2019-11-28.
 * Email : idisfkj@gmail.com.
 */
class NotificationVHVM : BaseRecyclerVM<NotificationModel>() {

    var data: NotificationModel? = null

    override fun onBind(model: NotificationModel?) {
        data = model
    }

    fun getTypeFlagSrc(type: String): Int {
        if (type == "PullRequest") {
            return R.drawable.pull_request
        } else if (type == "Issue") {
            return R.drawable.issue_open
        }
        return R.drawable.issue_closed
    }
}