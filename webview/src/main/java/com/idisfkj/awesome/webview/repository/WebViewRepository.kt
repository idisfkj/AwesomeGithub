package com.idisfkj.awesome.webview.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.NotificationRequestUrlModel
import com.idisfkj.awesome.network.GithubService
import com.idisfkj.awesome.network.HttpClient

/**
 * Created by idisfkj on 2019-12-03.
 * Email : idisfkj@gmail.com.
 */
class WebViewRepository(private val service: GithubService) : BaseRepository {

    suspend fun getNotificationRequestUrl(path: String): NotificationRequestUrlModel {
        val finalPath = if (path.startsWith(HttpClient.API_GITHUB_BASE_URL)) {
            path.substring(HttpClient.API_GITHUB_BASE_URL.length + 1)
        } else {
            path
        }
        return service.getNotificationRequestUrl(finalPath)
    }
}