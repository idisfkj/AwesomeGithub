package com.idisfkj.awesome.componentbridge.followers

import android.content.Context
import android.widget.Toast

/**
 * Created by idisfkj on 2019-11-21.
 * Email : idisfkj@gmail.com.
 */
class DefaultFollowersBridge : FollowersBridgeInterface {

    override fun toFollowersActivity(context: Context) {
        Toast.makeText(context, "toFollowersActivity", Toast.LENGTH_LONG).show()
    }
}