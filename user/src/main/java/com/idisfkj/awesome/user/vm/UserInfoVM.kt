package com.idisfkj.awesome.user.vm

import android.app.Application
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.UserModel

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserInfoVM(application: Application) : BaseRecyclerVM<UserModel>(application) {

    var data: UserModel? = null

    override fun onBind(model: UserModel?) {
        data = model
    }
}