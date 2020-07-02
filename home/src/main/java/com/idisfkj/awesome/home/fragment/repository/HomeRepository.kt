package com.idisfkj.awesome.home.fragment.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeRepository @Inject constructor(
    private val service: GithubService,
    scope: CoroutineScope
) : BaseRepository(scope) {

    fun getUser(callback: RequestCallback<UserModel>) {
        request(scope, callback) {
            service.getUser()
        }
    }

}