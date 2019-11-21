package com.idisfkj.awesome.repos.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.repos.adapter.ReposAdapter
import com.idisfkj.awesome.repos.repository.ReposRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposVM(private val repository: ReposRepository) : BaseVM() {

    val adapter = ReposAdapter()
    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getRepos(false)
    }

    private fun getRepos(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        request {
            val list = repository.getRepos()
            withContext(Dispatchers.Main) {
                isRefreshing.value = false
                showLoading.value = false
                if (refresh) {
                    adapter.clear()
                    adapter.notifyDataSetChanged()
                }
                adapter.addData(list)
            }
        }
    }

    fun onRefreshListener() {
        isRefreshing.value = true
        getRepos(true)
    }
}