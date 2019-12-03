package com.idisfkj.awesome.repos.bridge

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.repos.adapter.ReposAdapter

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
class ReposBridge : ReposBridgeInterface {

    override fun createReposAdapter(): BaseRecyclerViewAdapter = ReposAdapter()

    override fun toReposActivity(context: Context) {
        ARouter.getInstance().build(ARouterPaths.PATH_REPOS_REPOS).navigation(context)
    }

}