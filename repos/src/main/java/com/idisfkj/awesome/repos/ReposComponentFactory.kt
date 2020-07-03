package com.idisfkj.awesome.repos

import com.idisfkj.awesome.repos.di.ReposComponent

/**
 * Created by idisfkj on 2020/7/3.
 * Email: idisfkj@gmail.com.
 */
interface ReposComponentFactory {

    fun reposComponentFactory(): ReposComponent.Factory
}