package com.idisfkj.awesome.following.bridge

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.following.FollowingBridgeInterface

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingBridge : FollowingBridgeInterface {

    override fun toFollowingActivity(context: Context) {
        ARouter.getInstance().build(ARouterPaths.PATH_FOLLOWING_FOLLOWING).navigation(context)
    }
}