package com.idisfkj.awesome.notification.fragment.di

import com.idisfkj.awesome.notification.fragment.NotificationFragment
import com.idisfkj.awesome.notification.fragment.di.scope.NotificationScope
import dagger.Subcomponent

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@NotificationScope
@Subcomponent(modules = [NotificationFragmentModule::class, NotificationFragmentProviderModule::class])
interface NotificationFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(providerModule: NotificationFragmentProviderModule): NotificationFragmentComponent
    }

    fun inject(fragment: NotificationFragment)
}
