package com.idisfkj.awesome.search.di

import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by idisfkj on 2020/7/10.
 * Email: idisfkj@gmail.com.
 */
@InstallIn(ActivityComponent::class)
@Module
object SearchProviderModule {

    @Provides
    fun providerSearchAdapter() = BridgeProviders.instance.getBridge(ReposBridgeInterface::class.java).createReposAdapter()
}