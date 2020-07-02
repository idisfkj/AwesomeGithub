package com.idisfkj.awesome.user

import com.idisfkj.awesome.user.fragment.di.UserFragmentComponent

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface UserFragmentComponentFactory {

    fun userFragmentComponentFactory(): UserFragmentComponent.Factory
}