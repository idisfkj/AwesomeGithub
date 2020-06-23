package com.idisfkj.awesome.github.ui.main.di

import androidx.lifecycle.ViewModel
import com.idisfkj.awesome.github.di.ViewModelKey
import com.idisfkj.awesome.github.ui.main.MainVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by idisfkj on 2020/6/23.
 * Email: idisfkj@gmail.com.
 */
@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainVM::class)
    abstract fun bindViewModel(viewModel: MainVM): ViewModel

}