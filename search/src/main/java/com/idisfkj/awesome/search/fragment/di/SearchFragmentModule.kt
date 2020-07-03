package com.idisfkj.awesome.search.fragment.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.search.vm.SearchVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class SearchFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchVM::class)
    abstract fun bindViewModel(viewModel: SearchVM): ViewModel
}