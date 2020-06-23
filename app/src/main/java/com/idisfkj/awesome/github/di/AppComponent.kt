package com.idisfkj.awesome.github.di

import android.content.Context
import com.idisfkj.awesome.github.ui.main.di.MainComponent
import com.idisfkj.awesome.github.ui.welcome.di.WelcomeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/6/16.
 * Email: idisfkj@gmail.com.
 */
@Singleton
@Component(
    modules = [
        SubComponentModule::class,
        ViewModelBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun welcomeComponent(): WelcomeComponent.Factory

    fun mainComponent(): MainComponent.Factory

}

@Module(subcomponents = [WelcomeComponent::class, MainComponent::class])
object SubComponentModule

