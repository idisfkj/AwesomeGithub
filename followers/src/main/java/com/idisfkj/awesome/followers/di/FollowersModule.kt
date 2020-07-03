package com.idisfkj.awesome.followers.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.followers.vm.FollowersVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class FollowersModule {

    @Binds
    @IntoMap
    @ViewModelKey(FollowersVM::class)
    abstract fun bindViewModel(viewModel: FollowersVM): ViewModel
}