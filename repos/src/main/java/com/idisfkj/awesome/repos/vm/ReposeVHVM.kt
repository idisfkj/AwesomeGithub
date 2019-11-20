package com.idisfkj.awesome.repos.vm

import android.app.Application
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.ReposModel

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposeVHVM(application: Application) : BaseRecyclerVM<ReposModel>(application) {

    var data: ReposModel? = null

    override fun onBind(model: ReposModel?) {
        data = model
    }

    fun updateAtContent() = data?.run {
        val index = updated_at.indexOf("T")
        updated_at.substring(0, index)
    } ?: ""
}