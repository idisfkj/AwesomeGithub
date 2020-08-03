package com.idisfkj.awesome.github.startup

import com.idisfkj.awesome.github.BuildConfig
import com.rousetime.android_startup.model.LoggerLevel
import com.rousetime.android_startup.model.StartupConfig
import com.rousetime.android_startup.provider.StartupProviderConfig

/**
 * Created by idisfkj on 2020/8/3.
 * Email: idisfkj@gmail.com.
 */
class AwesomeGithubStartupConfig : StartupProviderConfig {

    override fun getConfig(): StartupConfig =
        StartupConfig.Builder()
            .setLoggerLevel(if (BuildConfig.DEBUG) LoggerLevel.DEBUG else LoggerLevel.NONE)
            .build()
}