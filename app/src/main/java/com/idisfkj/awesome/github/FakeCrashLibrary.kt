package com.idisfkj.awesome.github

/**
 * Created by idisfkj on 2019-08-13.
 * Email : idisfkj@gmail.com.
 */
object FakeCrashLibrary {

    fun log(priority: Int, tag: String?, message: String) {}

    fun logWarning(t: Throwable) {}

    fun logError(t: Throwable) {}
}