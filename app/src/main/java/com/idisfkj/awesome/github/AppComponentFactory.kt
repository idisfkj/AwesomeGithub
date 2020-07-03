package com.idisfkj.awesome.github

import com.idisfkj.awesome.followers.FollowersComponentFactory
import com.idisfkj.awesome.github.ui.main.di.MainComponent
import com.idisfkj.awesome.github.ui.welcome.di.WelcomeComponent
import com.idisfkj.awesome.home.HomeFragmentComponentFactory
import com.idisfkj.awesome.notification.NotificationFragmentComponentFactory
import com.idisfkj.awesome.repos.ReposComponentFactory
import com.idisfkj.awesome.search.SearchFragmentComponentFactory
import com.idisfkj.awesome.user.UserFragmentComponentFactory

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface AppComponentFactory : UserFragmentComponentFactory, HomeFragmentComponentFactory, NotificationFragmentComponentFactory,
    SearchFragmentComponentFactory, ReposComponentFactory, FollowersComponentFactory {

    fun mainComponentFactory(): MainComponent.Factory

    fun welcomeComponentFactory(): WelcomeComponent.Factory
}