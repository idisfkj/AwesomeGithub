package com.idisfkj.awesome.followers.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.followers.adapter.FollowersAdapter
import com.idisfkj.awesome.followers.repository.FollowersRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-11-21.
 * Email : idisfkj@gmail.com.
 */
class FollowersVM(private val repository: FollowersRepository) : BaseVM() {

    val adapter = FollowersAdapter()
    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getFollowers(false)
    }

    private fun getFollowers(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        request(handler = CoroutineExceptionHandler { _, _ ->
            showLoading.value = false
            isRefreshing.value = false
        }) {
            val list = repository.getFollowers()
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
        getFollowers(true)
    }
}