package com.idisfkj.awesome.home.fragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2020/6/24.
 * Email: idisfkj@gmail.com.
 */
@Module
class HomeFragmentProviderModule(private val viewModel: ViewModel) {

    @Provides
    fun providerViewModelScope(): CoroutineScope = viewModel.viewModelScope

}