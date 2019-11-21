package com.idisfkj.awesome.home.fragment.vm

import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.UserModel

/**
 * Created by idisfkj on 2019-09-04.
 * Email : idisfkj@gmail.com.
 */
class HomeUserInfoVM : BaseRecyclerVM<UserModel>() {
    var data: UserModel? = null

    override fun onBind(model: UserModel?) {
        data = model
    }

}