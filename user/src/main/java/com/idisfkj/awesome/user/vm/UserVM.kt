package com.idisfkj.awesome.user.vm

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.user.adapter.UserRecyclerViewAdapter
import com.idisfkj.awesome.user.repository.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserVM(private val repository: UserRepository, val userInfoVM: UserInfoVM) : BaseVM() {

    val userData = MutableLiveData<UserModel>()
    private val mAdapter = UserRecyclerViewAdapter(userInfoVM)
    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getUser(false)
    }

    private fun getUser(refresh: Boolean) {
        if (!refresh) showLoading.value = true
        request(handler = CoroutineExceptionHandler { _, _ ->
            showLoading.value = false
            isRefreshing.value = false
        }) {
            val userModel = repository.getUser()
            withContext(Dispatchers.Main) {
                showLoading.value = false
                isRefreshing.value = false
                val userInfo = userModel.copy()
                userInfo.itemType = TYPE_INFO
                if (refresh) {
                    mAdapter.clear()
                    mAdapter.notifyDataSetChanged()
                }
                mAdapter.addData(userInfo)
            }
        }
    }

    fun createAdapter() = mAdapter

    fun onRefreshListener() {
        isRefreshing.value = true
        getUser(true)
    }
}