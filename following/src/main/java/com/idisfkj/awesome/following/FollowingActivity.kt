package com.idisfkj.awesome.following

import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseActivity
import com.idisfkj.awesome.basic.activity.BaseHiltActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.following.databinding.FollowingActivityFollowingLayoutBinding
import com.idisfkj.awesome.following.vm.FollowingVM
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
@AndroidEntryPoint
@Route(path = ARouterPaths.PATH_FOLLOWING_FOLLOWING)
class FollowingActivity : BaseHiltActivity<FollowingActivityFollowingLayoutBinding, FollowingVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.following_activity_following_layout

    override fun getViewModelClass(): Class<FollowingVM> = FollowingVM::class.java
}