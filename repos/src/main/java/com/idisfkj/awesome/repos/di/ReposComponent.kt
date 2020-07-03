package com.idisfkj.awesome.repos.di

import com.idisfkj.awesome.repos.ReposActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [ReposModule::class, ReposProviderModule::class])
interface ReposComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: ReposProviderModule): ReposComponent
    }

    fun inject(reposActivity: ReposActivity)
}