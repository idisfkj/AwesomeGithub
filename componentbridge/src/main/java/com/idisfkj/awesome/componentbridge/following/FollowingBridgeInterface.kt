package com.idisfkj.awesome.componentbridge.following

import android.content.Context
import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
interface FollowingBridgeInterface : BridgeInterface {

    fun toFollowingActivity(context: Context)
}