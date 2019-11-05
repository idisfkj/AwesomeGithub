package com.idisfkj.awesome.componentbridge.factory

import com.idisfkj.awesome.componentbridge.BridgeInterface

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class NewInstanceFactory : Factory {

    companion object {
        val instance: NewInstanceFactory by lazy { NewInstanceFactory() }
    }

    override fun <T : BridgeInterface> create(bridgeClazz: Class<T>): T = try {
        bridgeClazz.newInstance()
    } catch (e: InstantiationException) {
        throw RuntimeException("Cannot create an instance of $bridgeClazz", e)
    } catch (e: IllegalAccessException) {
        throw RuntimeException("Cannot create an instance of $bridgeClazz", e)
    }

}