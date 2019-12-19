package com.idisfkj.awesome.notification.vm

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.notification.adapter.NotificationAdapter
import com.idisfkj.awesome.notification.repository.NotificationRepository
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationVM(outerLifecycle: Lifecycle) : BaseVM() {

    private val repository = NotificationRepository(HttpClient.getService(), viewModelScope)
    val isRefreshing = SingleLiveEvent<Boolean>()
    private val mAdapter = NotificationAdapter(repository, outerLifecycle)

    override fun attach(savedInstanceState: Bundle?) {
        getNotification(false)
    }

    private fun getNotification(isRefresh: Boolean) {
        if (!isRefresh) showLoading.value = true
        repository.getNotification(callback = object : RequestCallback<List<NotificationModel>> {
            override fun onSuccess(result: ResponseSuccess<List<NotificationModel>>) {
                showLoading.value = false
                isRefreshing.value = false
                result.data?.let {
                    if (isRefresh) {
                        mAdapter.clear()
                        mAdapter.notifyDataSetChanged()
                    }
                    mAdapter.addData(it)
                    Timber.d("size of getNotification: ${it.size}")
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
        getNotification(true)
    }

}