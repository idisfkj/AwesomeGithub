package com.idisfkj.awesome.componentbridge.repos

import android.content.Context
import android.widget.Toast

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
class DefaultReposBridge : ReposBridgeInterface {

    override fun toReposActivity(context: Context) {
        Toast.makeText(context, "toReposActivity", Toast.LENGTH_LONG).show()
    }
}