package com.idisfkj.awesome.repos.vm

import android.app.Application
import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.repos.adapter.ReposAdapter
import com.idisfkj.awesome.repos.repository.ReposRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposVM(
    application: Application,
    private val repository: ReposRepository
) : BaseVM(application) {

    val adapter = ReposAdapter()

    override fun attach(savedInstanceState: Bundle?) {
        getRepos()
    }

    private fun getRepos() {
        showLoading.value = true
        request {
            val reposMode = repository.getRepos()
            withContext(Dispatchers.Main) {
                showLoading.value = false
                Timber.d("getRepos: $reposMode")
            }
        }
    }
}