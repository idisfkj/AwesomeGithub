package com.idisfkj.awesome.following.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingRepository @Inject constructor(
    private val service: GithubService,
    scope: CoroutineScope
) : BaseRepository(scope) {

    fun getFollowing(callback: RequestCallback<List<FollowersModel>>) {
        request(scope = scope, callback = callback) {
            service.getFollowing()
        }
    }
}