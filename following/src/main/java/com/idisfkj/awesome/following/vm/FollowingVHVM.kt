package com.idisfkj.awesome.following.vm

import android.content.Context
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingVHVM(private val context: Context) : BaseRecyclerVM<FollowersModel>() {

    var data: FollowersModel? = null

    override fun onBind(model: FollowersModel?) {
        data = model
    }

    fun contentClick() {
        BridgeProviders.instance.getBridge(WebViewBridgeInterface::class.java)
            .toWebViewActivity(context, data?.html_url ?: "", "")
    }
}