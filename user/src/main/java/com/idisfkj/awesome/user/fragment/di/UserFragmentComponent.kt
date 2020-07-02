package com.idisfkj.awesome.user.fragment.di

import com.idisfkj.awesome.user.fragment.UserFragment
import com.idisfkj.awesome.user.fragment.di.scope.UserScope
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@UserScope
@Subcomponent(modules = [UserFragmentModule::class, UserFragmentProviderModule::class])
interface UserFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: UserFragmentProviderModule): UserFragmentComponent
    }

    fun inject(fragment: UserFragment)
}