package com.idisfkj.awesome.user.vm

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
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
class UserVM(
    application: Application,
    private val repository: UserRepository
) : BaseVM(application) {

    val userData = MutableLiveData<UserModel>()
    private val mAdapter = UserRecyclerViewAdapter(application)

    override fun attach(savedInstanceState: Bundle?) {
        getUser()
    }

    private fun getUser() {
        showLoading.value = true
        request(handler = CoroutineExceptionHandler { _, e ->
            showLoading.value = false
        }) {
            val userModel = repository.getUser()
            withContext(Dispatchers.Main) {
                showLoading.value = false
                val userInfo = userModel.copy()
                userInfo.itemType = TYPE_INFO
                mAdapter.addData(userInfo)
            }
        }
    }

    fun createAdapter() = mAdapter
}