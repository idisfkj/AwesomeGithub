package com.idisfkj.awesome.home.di

import android.content.Context
import com.idisfkj.awesome.componentbridge.di.ViewModelBuilderModule
import com.idisfkj.awesome.home.fragment.di.HomeFragmentComponent
import com.idisfkj.awesome.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/7/2.
 * Email: idisfkj@gmail.com.
 */
@Singleton
@Component(modules = [SubComponent::class, NetworkModule::class, ViewModelBuilderModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun homeFragmentComponent(): HomeFragmentComponent.Factory
}

@Module(subcomponents = [HomeFragmentComponent::class])
object SubComponent
