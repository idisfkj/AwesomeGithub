package com.idisfkj.awesome.following

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseDaggerActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.following.databinding.FollowingActivityFollowingLayoutBinding
import com.idisfkj.awesome.following.di.FollowingProviderModule
import com.idisfkj.awesome.following.vm.FollowingVM

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_FOLLOWING_FOLLOWING)
class FollowingActivity : BaseDaggerActivity<FollowingActivityFollowingLayoutBinding, FollowingVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.following_activity_following_layout

    override fun getViewModelClass(): Class<FollowingVM> = FollowingVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as FollowingComponentFactory).followingComponentFactory()
            .create(FollowingProviderModule(lifecycleScope)).inject(this)
        super.onCreate(savedInstanceState)
    }
}