package com.idisfkj.awesome.login

import com.idisfkj.awesome.login.di.LoginComponent

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
interface LoginComponentFactory {

    fun loginComponentFactory(): LoginComponent.Factory
}