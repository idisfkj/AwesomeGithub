package com.idisfkj.awesome.login

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
data class IssuesRequestModel(val title: String)

data class TokenRequestModel(
    val client_id: String,
    val client_secret: String,
    val code: String,
    val redirect_uri: String
)
