package com.idisfkj.awesome.common.model

/**
 * Created by idisfkj on 2019-12-02.
 * Email : idisfkj@gmail.com.
 */
data class SearchModel(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<ReposModel>
)
