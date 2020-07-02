package com.idisfkj.awesome.github.ui.welcome.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.componentbridge.di.ViewModelKey
import com.idisfkj.awesome.github.ui.welcome.WelcomeVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/6/16.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class WelcomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeVM::class)
    abstract fun bindViewModel(viewModel: WelcomeVM): ViewModel
}