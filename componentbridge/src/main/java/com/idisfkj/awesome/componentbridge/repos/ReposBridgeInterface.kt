package com.idisfkj.awesome.componentbridge.repos

import android.content.Context
import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
interface ReposBridgeInterface: BridgeInterface {

    fun toReposActivity(context: Context)
}