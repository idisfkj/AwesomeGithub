package com.idisfkj.awesome.followers.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope

/**
 * Created by idisfkj on 2019-11-22.
 * Email : idisfkj@gmail.com.
 */
class FollowersRepository(
    private val service: GithubService,
    scope: CoroutineScope
) : BaseRepository(scope) {

    fun getFollowers(callback: RequestCallback<List<FollowersModel>>) {
        request(scope = scope, callback = callback) { service.getFollowers() }
    }
}