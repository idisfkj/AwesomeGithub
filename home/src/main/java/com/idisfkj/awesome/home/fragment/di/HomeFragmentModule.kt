package com.idisfkj.awesome.home.fragment.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.home.fragment.vm.HomeVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/6/24.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class HomeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    abstract fun bindViewModel(vm: HomeVM): ViewModel

}