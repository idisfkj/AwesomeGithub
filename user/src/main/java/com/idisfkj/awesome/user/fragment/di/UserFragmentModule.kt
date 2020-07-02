package com.idisfkj.awesome.user.fragment.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.user.vm.UserVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class UserFragmentModule {

    @ViewModelKey(UserVM::class)
    @IntoMap
    @Binds
    abstract fun bindViewModel(vm: UserVM): ViewModel
}