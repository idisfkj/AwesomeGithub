package com.idisfkj.awesome.notification.vm

import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.model.NotificationModel
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.notification.adapter.NotificationAdapter
import com.idisfkj.awesome.notification.repository.NotificationRepository
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationVM @ViewModelInject constructor(
    private val repository: NotificationRepository,
    private val adapter: NotificationAdapter
) : BaseVM() {

    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getNotification(false)
    }

    private fun getNotification(isRefresh: Boolean) {
        if (!isRefresh) showLoading.value = true
        repository.getNotification(viewModelScope, callback = object : RequestCallback<List<NotificationModel>> {
            override fun onSuccess(result: ResponseSuccess<List<NotificationModel>>) {
                showLoading.value = false
                isRefreshing.value = false
                result.data?.let {
                    if (isRefresh) {
                        adapter.clear()
                        adapter.notifyDataSetChanged()
                    }
                    adapter.addData(it)
                    Timber.d("size of getNotification: ${it.size}")
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
        getNotification(true)
    }

}