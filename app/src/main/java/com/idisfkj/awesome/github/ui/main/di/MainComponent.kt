package com.idisfkj.awesome.github.ui.main.di

import com.idisfkj.awesome.github.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/6/23.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [MainModule::class, MainProviderModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(mainProviderModule: MainProviderModule): MainComponent
    }

    fun inject(activity: MainActivity)
}