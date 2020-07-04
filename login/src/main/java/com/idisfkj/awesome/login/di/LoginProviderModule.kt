package com.idisfkj.awesome.login.di

import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Module
class LoginProviderModule(private val scope: CoroutineScope) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope

    @Provides
    fun providerAppBridge(): AppBridgeInterface = BridgeProviders.instance.getBridge(AppBridgeInterface::class.java)

}