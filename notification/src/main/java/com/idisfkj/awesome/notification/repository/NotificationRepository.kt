package com.idisfkj.awesome.notification.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationRepository @Inject constructor(
    private val service: GithubService
) : BaseRepository() {

    fun getNotification(
        scope: CoroutineScope,
        all: Boolean = true,
        participating: Boolean = false,
        since: String = "",
        before: String = "",
        callback: RequestCallback<List<NotificationModel>>
    ) {
        request(scope, callback) {
            service.getNotification(
                mapOf(
                    "all" to all.toString(),
                    "participating" to participating.toString(),
                    "since" to since,
                    "before" to before
                )
            )
        }
    }

    fun markThreadRead(
        scope: CoroutineScope,
        threadId: String,
        callback: RequestCallback<retrofit2.Response<ResponseBody>>
    ) {
        request(scope, callback) {
            service.markThreadRead(threadId)
        }
    }
}