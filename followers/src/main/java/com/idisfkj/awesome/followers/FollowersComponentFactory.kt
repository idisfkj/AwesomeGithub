package com.idisfkj.awesome.followers

import com.idisfkj.awesome.followers.di.FollowersComponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
interface FollowersComponentFactory {

    fun followersComponentFactory(): FollowersComponent.Factory
}