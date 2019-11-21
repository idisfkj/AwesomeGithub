package com.idisfkj.awesome.repos.bridge

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
class ReposBridge : ReposBridgeInterface {

    override fun toReposActivity(context: Context) {
        ARouter.getInstance().build(ARouterPaths.PATH_REPOS_REPOS).navigation(context)
    }

}