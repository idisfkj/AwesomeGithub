package com.idisfkj.awesome.notification.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationRepository(private val service: GithubService) : BaseRepository {

    suspend fun getNotification(
        all: Boolean = false,
        participating: Boolean = false,
        since: String = "",
        before: String = ""
    ): List<NotificationModel> {
        return service.getNotification(
            mapOf(
                "all" to all.toString(),
                "participating" to participating.toString(),
                "since" to since,
                "before" to before
            )
        )
    }
}