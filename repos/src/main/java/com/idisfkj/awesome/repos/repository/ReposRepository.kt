package com.idisfkj.awesome.repos.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.ReposModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposRepository(private val service: GithubService) : BaseRepository {

    suspend fun getRepos(): List<ReposModel> {
        return service.getPros(mapOf("visibility" to "all", "sort" to "pushed"))
    }
}