package com.idisfkj.awesome.github.ui.main.di

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

/**
 * Created by idisfkj on 2020/6/23.
 * Email: idisfkj@gmail.com.
 */
@Module
class MainProviderModule(private val activity: FragmentActivity) {

    @Provides
    fun providersFragmentManager(): FragmentManager = activity.supportFragmentManager

}