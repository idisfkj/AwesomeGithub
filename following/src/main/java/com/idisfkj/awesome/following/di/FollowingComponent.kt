package com.idisfkj.awesome.following.di

import com.idisfkj.awesome.following.FollowingActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [FollowingModule::class, FollowingProviderModule::class])
interface FollowingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: FollowingProviderModule): FollowingComponent
    }

    fun inject(followingActivity: FollowingActivity)
}