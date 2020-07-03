package com.idisfkj.awesome.search.fragment.di

import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.componentbridge.provider.BridgeProvider
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
class SearchFragmentProviderModule(private val scope: CoroutineScope) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope

    @Provides
    fun providerReposAdapter(): BaseRecyclerViewAdapter = BridgeProviders.instance.getBridge(ReposBridgeInterface::class.java).createReposAdapter()
}