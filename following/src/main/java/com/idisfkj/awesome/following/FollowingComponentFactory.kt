package com.idisfkj.awesome.following

import com.idisfkj.awesome.following.di.FollowingComponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
interface FollowingComponentFactory {

    fun followingComponentFactory(): FollowingComponent.Factory
}