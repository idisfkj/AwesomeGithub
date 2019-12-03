package com.idisfkj.awesome.repos.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.PageDefault
import com.idisfkj.awesome.common.ReposToWebView
import com.idisfkj.awesome.common.ToPageStatus
import com.idisfkj.awesome.common.model.ReposModel
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.webview.WebViewBridgeInterface

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposVHVM(private val context: Context) : BaseRecyclerVM<ReposModel>() {

    var data: ReposModel? = null

    override fun onBind(model: ReposModel?) {
        data = model
    }

    fun updateAtContent() = data?.run {
        val index = updated_at.indexOf("T")
        updated_at.substring(0, index)
    } ?: ""

    fun contentClick() {
        BridgeProviders.instance.getBridge(WebViewBridgeInterface::class.java)
            .toWebViewActivity(context, data?.html_url ?: "")
    }
}