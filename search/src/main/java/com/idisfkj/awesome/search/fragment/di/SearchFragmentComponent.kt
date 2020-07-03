package com.idisfkj.awesome.search.fragment.di

import com.idisfkj.awesome.search.fragment.SearchFragment
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
@Subcomponent(modules = [SearchFragmentModule::class, SearchFragmentProviderModule::class])
interface SearchFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(searchProvider: SearchFragmentProviderModule): SearchFragmentComponent
    }

    fun inject(searchFragment: SearchFragment)
}