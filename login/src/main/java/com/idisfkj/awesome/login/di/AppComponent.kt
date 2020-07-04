package com.idisfkj.awesome.login.di

import android.content.Context
import com.idisfkj.awesome.componentbridge.di.ViewModelBuilderModule
import com.idisfkj.awesome.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/7/4.
 * Email: idisfkj@gmail.com.
 */
@Singleton
@Component(modules = [SubComponentModule::class, NetworkModule::class, ViewModelBuilderModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory
}

@Module(subcomponents = [LoginComponent::class])
object SubComponentModule