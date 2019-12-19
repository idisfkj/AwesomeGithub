package com.idisfkj.awesome.following.vm

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.following.adapter.FollowingAdapter
import com.idisfkj.awesome.following.repository.FollowingRepository
import com.idisfkj.awesome.network.HttpClient

/**
 * Created by idisfkj on 2019-11-26.
 * Email: idisfkj@gmail.com.
 */
class FollowingVM : BaseVM() {

    private val repository = FollowingRepository(HttpClient.getService(), viewModelScope)
    val adapter = FollowingAdapter()
    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getFollowers(false)
    }

    private fun getFollowers(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        repository.getFollowing(object : RequestCallback<List<FollowersModel>> {
            override fun onSuccess(result: ResponseSuccess<List<FollowersModel>>) {
                isRefreshing.value = false
                showLoading.value = false
                if (refresh) {
                    adapter.clear()
                    adapter.notifyDataSetChanged()
                }
                result.data?.let { adapter.addData(it) }
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
                isRefreshing.value = false
            }

        })
    }

    fun onRefreshListener() {
        isRefreshing.value = true
        getFollowers(true)
    }
}