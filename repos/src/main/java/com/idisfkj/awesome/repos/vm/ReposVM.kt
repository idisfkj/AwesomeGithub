package com.idisfkj.awesome.repos.vm

import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.ReposModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.repos.adapter.ReposAdapter
import com.idisfkj.awesome.repos.repository.ReposRepository

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposVM @ViewModelInject constructor(
    val adapter: ReposAdapter,
    private val repository: ReposRepository
) : BaseVM() {

    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getRepos(false)
    }

    private fun getRepos(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        repository.getRepos(viewModelScope, object : RequestCallback<List<ReposModel>> {
            override fun onSuccess(result: ResponseSuccess<List<ReposModel>>) {
                isRefreshing.value = false
                showLoading.value = false
                result.data?.let {
                    if (refresh) {
                        adapter.clear()
                        adapter.notifyDataSetChanged()
                    }
                    adapter.addData(it)
                }
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
                isRefreshing.value = false
            }

        })
    }

    fun onRefreshListener() {
        isRefreshing.value = true
        getRepos(true)
    }
}