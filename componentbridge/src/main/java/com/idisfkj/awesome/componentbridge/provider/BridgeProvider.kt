package com.idisfkj.awesome.componentbridge.provider

import com.idisfkj.awesome.componentbridge.BridgeInterface
import com.idisfkj.awesome.componentbridge.factory.Factory
import com.idisfkj.awesome.componentbridge.store.BridgeStore

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class BridgeProvider(private val factory: Factory) {

    val bridgeStore = BridgeStore()

    companion object {
        private const val DEFAULT_KEY = "com.idisfkj.awesome.componentbridge"
    }

    fun <T : BridgeInterface> get(key: String, bridgeClass: Class<T>): T {
        var componentBridge = bridgeStore.get(key)
        if (bridgeClass.isInstance(componentBridge)) {
            @Suppress("UNCHECKED_CAST")
            return componentBridge as T
        }
        componentBridge = factory.create(bridgeClass)
        bridgeStore.put(key, componentBridge)
        return componentBridge
    }

    fun <T : BridgeInterface> get(bridgeClass: Class<T>): T =
        get(DEFAULT_KEY + "@" + bridgeClass.canonicalName, bridgeClass)
}