package com.idisfkj.awesome.common.model

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */

data class NotificationModel(
    val id: String,
    val repository: ReposModel,
    val subject: SubjectModel,
    val reason: String,
    val unread: Boolean,
    val updated_at: String,
    val last_read_at: String,
    val url: String
) : BaseRecyclerViewModel()

data class SubjectModel(
    val title: String,
    val url: String,
    val latest_comment_url: String,
    val type: String
)

data class NotificationRequestUrlModel(
    val url: String,
    val id: Long,
    val html_url: String,
    val userModel: UserModel,
    val body: String
)