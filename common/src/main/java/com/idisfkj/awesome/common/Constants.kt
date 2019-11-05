package com.idisfkj.awesome.common

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
object Constants {
    const val AUTHORIZATION_CODE = "code"
    const val CLIENT_ID = "a36f72d09eb4c9ee207a"
    const val CLIENT_SECRET = "c11cfe68bfc7a8c4753bfdbf036a94ff943b972c"
    const val REDIRECT_URI = "github://login"
    const val AUTHORIZATION_URL =
        "https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=user%20repo%20notifications%20"
}