package com.idisfkj.awesome.following.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.following.adapter.FollowingAdapter
import com.idisfkj.awesome.following.repository.FollowingRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingVM(private val repository: FollowingRepository) : BaseVM() {

    val adapter = FollowingAdapter()
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
            val list = repository.getFollowing()
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