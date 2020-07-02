package com.idisfkj.awesome.home

import com.idisfkj.awesome.home.fragment.di.HomeFragmentComponent

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface HomeFragmentComponentFactory {

    fun homeFragmentComponentFactory(): HomeFragmentComponent.Factory
}