package com.idisfkj.awesome.repos.vm

import android.app.Application
import android.os.Bundle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.repos.adapter.ReposAdapter
import com.idisfkj.awesome.repos.repository.ReposRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-11-20.
 * Email : idisfkj@gmail.com.
 */
class ReposVM(
    application: Application,
    private val repository: ReposRepository
) : BaseVM(application) {

    val adapter = ReposAdapter(application)

    override fun attach(savedInstanceState: Bundle?) {
        getRepos()
    }

    private fun getRepos() {
        showLoading.value = true
        request {
            val list = repository.getRepos()
            withContext(Dispatchers.Main) {
                showLoading.value = false
                adapter.addData(list)
            }
        }
    }
}