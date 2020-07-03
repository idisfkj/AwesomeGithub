package com.idisfkj.awesome.search

import com.idisfkj.awesome.search.fragment.di.SearchFragmentComponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
interface SearchFragmentComponentFactory {

    fun searchFragmentComponentFactory(): SearchFragmentComponent.Factory
}