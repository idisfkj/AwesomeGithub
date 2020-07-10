package com.idisfkj.awesome.notification.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface
import com.idisfkj.awesome.notification.R
import com.idisfkj.awesome.notification.repository.NotificationRepository
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by idisfkj on 2019-11-28.
 * Email : idisfkj@gmail.com.
 */
class NotificationVHVM(
    private val context: Context,
    private val repository: NotificationRepository
) : BaseRecyclerVM<NotificationModel>() {

    var data: NotificationModel? = null
    val unread = MutableLiveData<Boolean>()

    override fun onBind(model: NotificationModel?) {
        data = model
        unread.value = data?.unread
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
        repository.markThreadRead(viewModelScope, threadId, object : RequestCallback<Response<ResponseBody>> {
            override fun onSuccess(result: ResponseSuccess<Response<ResponseBody>>) {
                if (result.data?.isSuccessful == true) {
                    data?.unread = false
                    unread.value = false
                }
            }

            override fun onError(error: ResponseError) {}
        })
    }

    fun contentClick() {
        markThreadRead(data?.id ?: "")
        BridgeProviders.instance.getBridge(WebViewBridgeInterface::class.java)
            .toWebViewActivity(context, requestUrl = data?.subject?.url ?: "")
    }
}