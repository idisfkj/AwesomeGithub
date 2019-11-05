package com.idisfkj.awesome.common.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringDef

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
object SPUtils {

    private lateinit var INSTANCE: SharedPreferences
    private const val SP_NAME = "awesome_github_sp"

    const val KEY_ACCESS_TOKEN = "access_token"
    const val KEY_USER_NAME = "username"
    const val KEY_REAL_USER_NAME = "real_user_name"
    const val KEY_AUTHORIZATION_BASIC = "authorization_basic"
    const val KEY_PASSWORD = "password"

    @StringDef(
        KEY_ACCESS_TOKEN,
        KEY_USER_NAME,
        KEY_REAL_USER_NAME,
        KEY_AUTHORIZATION_BASIC,
        KEY_PASSWORD
    )
    @Target(AnnotationTarget.VALUE_PARAMETER)
    @Retention(AnnotationRetention.SOURCE)
    annotation class SPKey

    fun init(app: Application) {
        INSTANCE = app.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    private fun getInstance(): SharedPreferences {
        return INSTANCE
    }

    fun putString(@SPKey key: String, value: String?) {
        getInstance().edit().putString(key, value).apply()
    }

    fun getString(@SPKey key: String, defaultValue: String = ""): String? {
        return getInstance().getString(key, defaultValue)
    }
}
