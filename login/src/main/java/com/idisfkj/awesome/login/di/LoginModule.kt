package com.idisfkj.awesome.login.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.login.LoginVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginVM::class)
    abstract fun bindViewModel(viewModel: LoginVM): ViewModel
}