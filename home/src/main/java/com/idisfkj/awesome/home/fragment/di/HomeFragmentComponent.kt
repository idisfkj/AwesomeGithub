package com.idisfkj.awesome.home.fragment.di

import com.idisfkj.awesome.home.fragment.HomeFragment
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/6/24.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [HomeFragmentModule::class, HomeFragmentProviderModule::class])
interface HomeFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: HomeFragmentProviderModule): HomeFragmentComponent
    }

    fun inject(fragment: HomeFragment)

}