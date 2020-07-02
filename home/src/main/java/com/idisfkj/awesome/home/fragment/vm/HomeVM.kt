package com.idisfkj.awesome.home.fragment.vm

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.home.fragment.adapter.HomeRecyclerViewAdapter
import com.idisfkj.awesome.home.fragment.repository.HomeRepository
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeVM @Inject constructor(
    private val repository: HomeRepository,
    private val adapter: HomeRecyclerViewAdapter
) : BaseVM() {

    val userData = MutableLiveData<UserModel>()
    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getUser(false)
    }

    private fun getUser(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        repository.getUser(object : RequestCallback<UserModel> {
            override fun onSuccess(result: ResponseSuccess<UserModel>) {
                showLoading.value = false
                isRefreshing.value = false
                if (refresh) {
                    adapter.clear()
                }
                result.data?.let {
                    val userInfo = it.copy()
                    userInfo.itemType = TYPE_INFO
                    adapter.addData(userInfo)
                }
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
                isRefreshing.value = false
            }

        })
    }

    fun createAdapter() = adapter

    fun onRefreshListener() {
        isRefreshing.value = true
        getUser(true)
    }
}
