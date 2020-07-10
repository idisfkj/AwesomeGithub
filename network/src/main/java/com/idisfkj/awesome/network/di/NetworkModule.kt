package com.idisfkj.awesome.network.di

import com.idisfkj.awesome.network.HttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Created by idisfkj on 2020/7/10.
 * Email: idisfkj@gmail.com.
 */
@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providerHttpClient() = HttpClient.getService()
}