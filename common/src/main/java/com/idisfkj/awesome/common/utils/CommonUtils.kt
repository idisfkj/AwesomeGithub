package com.idisfkj.awesome.common.utils

import android.content.Context
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
object CommonUtils {

    fun getUsername(): String = SPUtils.getString(SPUtils.KEY_USER_NAME) ?: ""

    fun getRealUserName(): String = SPUtils.getString(SPUtils.KEY_REAL_USER_NAME) ?: ""

    fun getPassword(): String = SPUtils.getString(SPUtils.KEY_PASSWORD) ?: ""

    fun isBasicLogin() = !TextUtils.isEmpty(SPUtils.getString(SPUtils.KEY_AUTHORIZATION_BASIC))

    fun hasToken() = !TextUtils.isEmpty(SPUtils.getString(SPUtils.KEY_ACCESS_TOKEN))

    fun hasLogin() = isBasicLogin() || hasToken()

//    fun getAuthorization() = if (isBasicLogin()) "Basic " + App.AUTHORIZATION_BASIC else "token " + App.ACCESS_TOKEN

    fun parseToJsonObject(src: Any): JsonObject =
        JsonParser().parse(Gson().toJson(src)).asJsonObject

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5).toInt()
    }
}