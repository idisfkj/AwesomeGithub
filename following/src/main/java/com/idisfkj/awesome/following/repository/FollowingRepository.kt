package com.idisfkj.awesome.following.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingRepository(private val service: GithubService) : BaseRepository {

    suspend fun getFollowing(): List<FollowersModel> {
       return service.getFollowing()
    }
}