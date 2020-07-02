package com.idisfkj.awesome.componentbridge.di

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface AppComponentFactory<T> {

    fun create(): T

}