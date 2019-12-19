package com.idisfkj.awesome.webview.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.NotificationRequestUrlModel
import com.idisfkj.awesome.network.GithubService
import com.idisfkj.awesome.network.HttpClient
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2019-12-03.
 * Email : idisfkj@gmail.com.
 */
class WebViewRepository(
    private val service: GithubService,
    scope: CoroutineScope
) : BaseRepository(scope) {

    fun getNotificationRequestUrl(
        path: String,
        callback: RequestCallback<NotificationRequestUrlModel>
    ) {
        val finalPath = if (path.startsWith(HttpClient.API_GITHUB_BASE_URL)) {
            path.substring(HttpClient.API_GITHUB_BASE_URL.length + 1)
        } else {
            path
        }
        request(scope, callback) {
            service.getNotificationRequestUrl(finalPath)
        }
    }
}