package com.idisfkj.awesome.github.ui.welcome.di

import com.idisfkj.awesome.github.ui.welcome.WelcomeActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/6/16.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): WelcomeComponent
    }

    fun inject(activity: WelcomeActivity)
}