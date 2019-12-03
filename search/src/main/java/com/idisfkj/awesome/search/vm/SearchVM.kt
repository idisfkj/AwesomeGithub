package com.idisfkj.awesome.search.vm

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.search.repository.SearchRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
class SearchVM(private val repository: SearchRepository) : BaseVM() {

    private val mAdapter =
        BridgeProviders.instance.getBridge(ReposBridgeInterface::class.java).createReposAdapter()

    val clearFocus = MutableLiveData<Boolean>(true)

    override fun attach(savedInstanceState: Bundle?) {
        search("android-api-analysis")
    }

    private fun search(query: String?) {
        query?.let {
            showLoading.value = true
            request(handler = CoroutineExceptionHandler { _, _ ->
                showLoading.value = false
            }) {
                val result = repository.searchRepository(it)
                withContext(Dispatchers.Main) {
                    showLoading.value = false
                    getAdapter().clear()
                    getAdapter().addData(result.items)
                }
            }
        }
    }

    fun getAdapter() = mAdapter

    fun setOnQueryTextListener() = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            clearFocus.value = true
            searchSubmit(query)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            clearFocus.value = false
            return true
        }
    }

    private fun searchSubmit(query: String?) {
        search(query)
    }
}