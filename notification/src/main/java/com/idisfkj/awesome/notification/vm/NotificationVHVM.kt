package com.idisfkj.awesome.notification.vm

import android.content.Context
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.repository.NotificationRepository
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-28.
 * Email : idisfkj@gmail.com.
 */
class NotificationVHVM(
    private val context: Context,
    private val repository: NotificationRepository
) : BaseRecyclerVM<NotificationModel>() {

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

    private fun markThreadRead(threadId: String) {
        request {
            val response = repository.markThreadRead(threadId)
            Timber.d("markThreadRead: ${response.isSuccessful}")
        }
    }

    fun contentClick() {
        markThreadRead(data?.id ?: "")
        BridgeProviders.instance.getBridge(WebViewBridgeInterface::class.java)
            .toWebViewActivity(context, requestUrl = data?.subject?.url ?: "")
    }
}