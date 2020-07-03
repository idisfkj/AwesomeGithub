package com.idisfkj.awesome.followers.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
class FollowersProviderModule(private val scope: CoroutineScope) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope
}