package com.idisfkj.awesome.home.fragment.vm

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.home.fragment.adapter.HomeRecyclerViewAdapter
import com.idisfkj.awesome.home.fragment.repository.HomeRepository
import com.idisfkj.awesome.network.HttpClient

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeVM : BaseVM() {

    private val repository = HomeRepository(HttpClient.getService(), viewModelScope)
    val userData = MutableLiveData<UserModel>()
    private val mAdapter = HomeRecyclerViewAdapter()
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
                    mAdapter.clear()
                }
                result.data?.let {
                    val userInfo = it.copy()
                    userInfo.itemType = TYPE_INFO
                    mAdapter.addData(userInfo)
                }
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
                isRefreshing.value = false
            }

        })
    }

    fun createAdapter() = mAdapter

    fun onRefreshListener() {
        isRefreshing.value = true
        getUser(true)
    }
}
