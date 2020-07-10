package com.idisfkj.awesome.notification.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

/**
 * Created by idisfkj on 2020/7/10.
 * Email: idisfkj@gmail.com.
 */
@InstallIn(ActivityComponent::class)
@Module
object NotificationProviderModule {

    @Provides
    fun providerLifecycle(@ActivityContext context: Context) = (context as FragmentActivity).lifecycle
}