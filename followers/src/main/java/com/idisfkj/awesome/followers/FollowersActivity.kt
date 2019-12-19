package com.idisfkj.awesome.followers

import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.followers.databinding.FollowersActivityFollowersLayoutBinding
import com.idisfkj.awesome.followers.vm.FollowersVM

/**
 * Created by idisfkj on 2019-11-21.
 * Email : idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_FOLLOWERS_FOLLOWERS)
class FollowersActivity : BaseActivity<FollowersActivityFollowersLayoutBinding, FollowersVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.followers_activity_followers_layout

    override fun getViewModelInstance(): FollowersVM = FollowersVM()

    override fun getViewModelClass(): Class<FollowersVM> = FollowersVM::class.java
}