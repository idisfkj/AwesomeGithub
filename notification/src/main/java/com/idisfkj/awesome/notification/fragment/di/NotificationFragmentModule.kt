package com.idisfkj.awesome.notification.fragment.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.notification.vm.NotificationVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class NotificationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotificationVM::class)
    abstract fun bindViewModel(vm: NotificationVM): ViewModel

}