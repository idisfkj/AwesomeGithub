package com.idisfkj.awesome.search.repository

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.SearchModel
import com.idisfkj.awesome.network.GithubService
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-12-02.
 * Email : idisfkj@gmail.com.
 */
class SearchRepository @Inject constructor(
    private val service: GithubService
) : BaseRepository() {

    fun searchRepository(scope: CoroutineScope, query: String, callback: RequestCallback<SearchModel>) {
        request(
            scope = scope,
            callback = callback
        ) { service.searchRepository(hashMapOf("q" to query)) }
    }
}