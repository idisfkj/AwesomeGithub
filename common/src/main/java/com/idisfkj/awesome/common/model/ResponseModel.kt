package com.idisfkj.awesome.common.model

/**
 * Created by idisfkj on 2019-09-04.
 * Email : idisfkj@gmail.com.
 */

const val TYPE_INFO = 1

data class UserModel(
    val id: String,
    val login: String,
    val avatar_url: String,
    val name: String,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int,
    val email: String,
    val blog: String,
    val company: String?,
    val location: String,
    val url: String,
    val bio: String,
    val node_id: String,
    val total_private_repos: Int
) : BaseRecyclerViewModel(itemType = TYPE_INFO)

data class IssuesModel(
    val id: Int,
    val node_id: String,
    val url: String,
    val state: String,
    val title: String,
    val body: String
)

data class ReposModel(
    val id: Int
)
