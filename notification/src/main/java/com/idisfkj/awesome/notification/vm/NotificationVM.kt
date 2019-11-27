package com.idisfkj.awesome.notification.vm

import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.notification.repository.NotificationRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-27.
 * Email: idisfkj@gmail.com.
 */
class NotificationVM(private val repository: NotificationRepository) : BaseVM() {

    val isRefreshing = SingleLiveEvent<Boolean>()

    override fun attach(savedInstanceState: Bundle?) {
        getNotification(false)
    }

    private fun getNotification(isRefresh: Boolean) {
        if (!isRefresh) showLoading.value = true
        request(handler = CoroutineExceptionHandler { _, _ ->
            showLoading.value = false
            isRefreshing.value = false
        }) {
            val result = repository.getNotification()
            withContext(Dispatchers.Main) {
                showLoading.value = false
                isRefreshing.value = false
                Timber.d("size of getNotification: ${result.size}")
            }
        }
    }

    fun createAdapter() = null

    fun onRefreshListener() {
        isRefreshing.value = true
        getNotification(true)
    }

}