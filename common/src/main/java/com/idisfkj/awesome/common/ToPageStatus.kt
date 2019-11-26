package com.idisfkj.awesome.common

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
sealed class ToPageStatus

object PageDefault : ToPageStatus()
object WelcomeToMain : ToPageStatus()
object WelcomeToLogin : ToPageStatus()
object LoginToMain : ToPageStatus()
object LoginToAuthorize: ToPageStatus()
object UserToRepos: ToPageStatus()
object UserToFollowers: ToPageStatus()
object UserToFollowing: ToPageStatus()
