package com.idisfkj.awesome.github

import com.idisfkj.awesome.followers.FollowersComponentFactory
import com.idisfkj.awesome.following.FollowingComponentFactory
import com.idisfkj.awesome.github.ui.main.di.MainComponent
import com.idisfkj.awesome.github.ui.welcome.di.WelcomeComponent
import com.idisfkj.awesome.home.HomeFragmentComponentFactory
import com.idisfkj.awesome.login.LoginComponentFactory
import com.idisfkj.awesome.notification.NotificationFragmentComponentFactory
import com.idisfkj.awesome.repos.ReposComponentFactory
import com.idisfkj.awesome.search.SearchFragmentComponentFactory
import com.idisfkj.awesome.user.UserFragmentComponentFactory
import com.idisfkj.awesome.webview.WebViewComponentFactory

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
interface AppComponentFactory : UserFragmentComponentFactory, HomeFragmentComponentFactory, NotificationFragmentComponentFactory,
    SearchFragmentComponentFactory, ReposComponentFactory, FollowersComponentFactory, FollowingComponentFactory,
    WebViewComponentFactory, LoginComponentFactory {

    fun mainComponentFactory(): MainComponent.Factory

    fun welcomeComponentFactory(): WelcomeComponent.Factory
}