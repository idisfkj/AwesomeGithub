package com.idisfkj.awesome.notification.di

import android.content.Context
import com.idisfkj.awesome.componentbridge.di.ViewModelBuilderModule
import com.idisfkj.awesome.network.di.NetworkModule
import com.idisfkj.awesome.notification.fragment.di.NotificationFragmentComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@Singleton
@Component(modules = [SubComponentModule::class, NetworkModule::class, ViewModelBuilderModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun notificationFragmentComponent(): NotificationFragmentComponent.Factory

}

@Module(subcomponents = [NotificationFragmentComponent::class])
object SubComponentModule