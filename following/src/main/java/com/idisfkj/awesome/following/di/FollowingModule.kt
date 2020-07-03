package com.idisfkj.awesome.following.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.following.vm.FollowingVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class FollowingModule {

    @Binds
    @IntoMap
    @ViewModelKey(FollowingVM::class)
    abstract fun bindViewModel(viewModel: FollowingVM): ViewModel
}