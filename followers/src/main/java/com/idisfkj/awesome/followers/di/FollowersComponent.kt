package com.idisfkj.awesome.followers.di

import com.idisfkj.awesome.followers.FollowersActivity
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [FollowersModule::class, FollowersProviderModule::class])
interface FollowersComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: FollowersProviderModule): FollowersComponent
    }

    fun inject(followersActivity: FollowersActivity)

}