package com.idisfkj.awesome.login.di

import com.idisfkj.awesome.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [LoginModule::class, LoginProviderModule::class])
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: LoginProviderModule): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
}