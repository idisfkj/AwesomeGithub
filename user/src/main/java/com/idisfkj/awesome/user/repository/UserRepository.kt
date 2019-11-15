package com.idisfkj.awesome.user.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserRepository(private val service: GithubService) : BaseRepository {

    suspend fun getUser(): UserModel {
        return service.getUser()
    }
}