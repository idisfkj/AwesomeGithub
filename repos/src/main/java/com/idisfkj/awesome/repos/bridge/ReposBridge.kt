package com.idisfkj.awesome.repos.bridge

import android.content.Context
import android.content.Intent
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.repos.ReposActivity

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
class ReposBridge : ReposBridgeInterface {

    override fun toReposActivity(context: Context) {
        context.startActivity(Intent(context, ReposActivity::class.java))
    }

}