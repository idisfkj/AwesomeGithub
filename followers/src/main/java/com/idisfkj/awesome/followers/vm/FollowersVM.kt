package com.idisfkj.awesome.followers.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.FollowersModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.followers.adapter.FollowersAdapter
import com.idisfkj.awesome.followers.repository.FollowersRepository
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-21.
 * Email : idisfkj@gmail.com.
 */
class FollowersVM @Inject constructor(
    private val repository: FollowersRepository,
    val adapter: FollowersAdapter
) : BaseVM() {

    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getFollowers(false)
    }

    private fun getFollowers(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        repository.getFollowers(object : RequestCallback<List<FollowersModel>> {
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