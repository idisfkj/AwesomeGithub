package com.idisfkj.awesome.componentbridge.following

import android.content.Context
import android.widget.Toast

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class DefaultFollowingBridge : FollowingBridgeInterface {

    override fun toFollowingActivity(context: Context) {
        Toast.makeText(context, "toFollowingActivity", Toast.LENGTH_LONG).show()
    }
}