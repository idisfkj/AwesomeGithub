package com.idisfkj.awesome.network.di

import com.idisfkj.awesome.network.GithubService
import com.idisfkj.awesome.network.HttpClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/6/24.
 * Email: idisfkj@gmail.com.
 */
@Module
object NetworkModule {

    @JvmStatic
    @Singleton
    @Provides
    fun providerGithubService(): GithubService = HttpClient.getService()

}