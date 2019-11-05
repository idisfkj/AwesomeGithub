package com.idisfkj.awesome.componentbridge.store

import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * bridge store
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class BridgeStore {

    private val mMap = HashMap<String, BridgeInterface>()

    fun put(key: String, bridge: BridgeInterface) {
        mMap.put(key, bridge)?.onClear()
    }

    fun get(key: String): BridgeInterface? = mMap[key]

    fun clear() {
        for (item in mMap.values) {
            item.onClear()
        }
        mMap.clear()
    }
}