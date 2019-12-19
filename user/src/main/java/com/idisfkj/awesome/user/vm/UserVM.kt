package com.idisfkj.awesome.user.vm

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
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.user.adapter.UserRecyclerViewAdapter
import com.idisfkj.awesome.user.repository.UserRepository

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserVM(val userInfoVM: UserInfoVM) : BaseVM() {

    private val repository = UserRepository(HttpClient.getService(), viewModelScope)
    val userData = MutableLiveData<UserModel>()
    private val mAdapter = UserRecyclerViewAdapter(userInfoVM)
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
                val userInfo = result.data?.copy()
                userInfo?.itemType = TYPE_INFO
                userInfo?.let {
                    if (refresh) {
                        mAdapter.clear()
                        mAdapter.notifyDataSetChanged()
                    }
                    mAdapter.addData(it)
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