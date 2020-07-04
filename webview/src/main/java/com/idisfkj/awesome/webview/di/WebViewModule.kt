package com.idisfkj.awesome.webview.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.webview.vm.WebViewVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class WebViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(WebViewVM::class)
    abstract fun bindViewModel(viewModel: WebViewVM): ViewModel
}