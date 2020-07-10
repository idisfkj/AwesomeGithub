package com.idisfkj.awesome.user.vm

import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.ToPageStatus
import com.idisfkj.awesome.common.UserToFollowers
import com.idisfkj.awesome.common.UserToFollowing
import com.idisfkj.awesome.common.UserToRepos
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.UserModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserInfoVM @Inject constructor() : BaseRecyclerVM<UserModel>() {

    var data: UserModel? = null
    var navigate: SingleLiveEvent<ToPageStatus> = SingleLiveEvent()

    override fun onBind(model: UserModel?) {
        data = model
    }

    fun reposClick() {
        navigate.value = UserToRepos
    }

    fun followersClick() {
        navigate.value = UserToFollowers
    }

    fun followingClick() {
        navigate.value = UserToFollowing
    }
}