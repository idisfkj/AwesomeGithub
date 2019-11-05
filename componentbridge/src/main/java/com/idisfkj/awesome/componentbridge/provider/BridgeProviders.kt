package com.idisfkj.awesome.componentbridge.provider

import com.idisfkj.awesome.componentbridge.BridgeInterface
import com.idisfkj.awesome.componentbridge.factory.Factory
import com.idisfkj.awesome.componentbridge.factory.NewInstanceFactory

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class BridgeProviders {

    private val mProvidersMap = HashMap<Class<*>, BridgeProvider>()
    private val mBridgeMap = HashMap<Class<*>, Class<*>>()
    private val mDefaultBridgeProvider = BridgeProvider(NewInstanceFactory.instance)

    companion object {
        val instance: BridgeProviders by lazy { BridgeProviders() }
    }

    fun <T : BridgeInterface> register(
        clazz: Class<T>,
        factory: Factory? = null,
        replace: Boolean = false
    ) = apply {
        if (clazz.interfaces.isEmpty() || !clazz.interfaces[0].interfaces.contains(BridgeInterface::class.java)) {
            throw RuntimeException("$clazz must implement BridgeInterface")
        }
        // 1. get contract interface as key, and save implement class to map value.
        // 2. get contract interface as key, and save bridgeProvider of implement class instance
        // to map value.
        clazz.interfaces[0].let {
            if (mProvidersMap[it] == null || replace) {
                mBridgeMap[it] = clazz
                mProvidersMap[it] = if (factory == null) {
                    mDefaultBridgeProvider
                } else {
                    BridgeProvider(factory)
                }
            }
        }
    }

    fun <T : BridgeInterface> getBridge(clazz: Class<T>): T {
        mProvidersMap[clazz]?.let {
            @Suppress("UNCHECKED_CAST")
            return it.get(mBridgeMap[clazz] as Class<T>)
        }
        throw RuntimeException("$clazz subClass is not register")
    }

    fun clear() {
        mProvidersMap.clear()
        mBridgeMap.clear()
        mDefaultBridgeProvider.bridgeStore.clear()
    }
}