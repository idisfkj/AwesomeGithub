package com.idisfkj.awesome.followers.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-11-22.
 * Email : idisfkj@gmail.com.
 */
class FollowersRepository(private val service: GithubService) : BaseRepository {

    suspend fun getFollowers(): List<FollowersModel> {
        return service.getFollowers()
    }
}