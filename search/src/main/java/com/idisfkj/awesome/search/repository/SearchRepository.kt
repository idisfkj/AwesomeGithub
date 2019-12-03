package com.idisfkj.awesome.search.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.model.SearchModel
import com.idisfkj.awesome.network.GithubService

/**
 * Created by idisfkj on 2019-12-02.
 * Email : idisfkj@gmail.com.
 */
class SearchRepository(private val service: GithubService) : BaseRepository {

    suspend fun searchRepository(query: String): SearchModel {
        return service.searchRepository(hashMapOf("q" to query))
    }
}