package com.idisfkj.awesome.login.di

import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by idisfkj on 2020/7/13.
 * Email: idisfkj@gmail.com.
 */
@InstallIn(ActivityComponent::class)
@Module
object LoginProviderModule {

    @Provides
    fun providerAppBridgeInterface() = BridgeProviders.instance.getBridge(AppBridgeInterface::class.java)
}