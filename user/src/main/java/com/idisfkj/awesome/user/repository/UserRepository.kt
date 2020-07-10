package com.idisfkj.awesome.user.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserRepository @Inject constructor(
    private val service: GithubService
) : BaseRepository() {

    fun getUser(scope: CoroutineScope, callback: RequestCallback<UserModel>) {
        request(scope, callback) {
            service.getUser()
        }
    }
}