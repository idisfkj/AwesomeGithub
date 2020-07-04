package com.idisfkj.awesome.webview.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Module
class WebViewProviderModule(private val scope: CoroutineScope) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = scope
}