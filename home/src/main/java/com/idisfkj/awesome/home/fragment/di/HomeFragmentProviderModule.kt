package com.idisfkj.awesome.home.fragment.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/6/24.
 * Email: idisfkj@gmail.com.
 */
@Module
class HomeFragmentProviderModule(private val scope: CoroutineScope) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope

}