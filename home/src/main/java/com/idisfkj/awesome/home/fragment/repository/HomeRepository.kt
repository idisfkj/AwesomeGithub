package com.idisfkj.awesome.home.fragment.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeRepository(private val service: GithubService) : BaseRepository {

    suspend fun getUser(): UserModel {
        return service.getUser()
    }

}