package com.idisfkj.awesome.user.vm

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.user.adapter.UserRecyclerViewAdapter
import com.idisfkj.awesome.user.repository.UserRepository
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserVM @Inject constructor(
    val userInfoVM: UserInfoVM,
    private val repository: UserRepository,
    private val adapter: UserRecyclerViewAdapter
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
                val userInfo = result.data?.copy()
                userInfo?.itemType = TYPE_INFO
                userInfo?.let {
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

    fun createAdapter() = adapter

    fun onRefreshListener() {
        isRefreshing.value = true
        getUser(true)
    }
}