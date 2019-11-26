package com.idisfkj.awesome.following.vm

import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.FollowersModel

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingVHVM : BaseRecyclerVM<FollowersModel>() {

    var data: FollowersModel? = null

    override fun onBind(model: FollowersModel?) {
        data = model
    }
}