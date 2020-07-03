package com.idisfkj.awesome.repos.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.repos.vm.ReposVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class ReposModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReposVM::class)
    abstract fun bindViewModel(viewModel: ReposVM): ViewModel
}