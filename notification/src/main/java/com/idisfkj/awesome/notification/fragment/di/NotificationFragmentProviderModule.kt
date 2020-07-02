package com.idisfkj.awesome.notification.fragment.di

import androidx.lifecycle.Lifecycle
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@Module
class NotificationFragmentProviderModule(
    private val lifecycle: Lifecycle,
    private val scope: CoroutineScope
) {

    @Provides
    fun providerLifecycle(): Lifecycle = lifecycle

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope
}