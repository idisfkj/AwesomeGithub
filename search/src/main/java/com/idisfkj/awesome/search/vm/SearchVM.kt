package com.idisfkj.awesome.search.vm

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.model.SearchModel
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.search.repository.SearchRepository

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
class SearchVM @ViewModelInject constructor(
    private val repository: SearchRepository,
    private val adapter: BaseRecyclerViewAdapter
) : BaseVM() {

    val clearFocus = MutableLiveData<Boolean>(true)

    override fun attach(savedInstanceState: Bundle?) {
        search("android-api-analysis")
    }

    private fun search(query: String?) {
        query?.let {
            showLoading.value = true
            repository.searchRepository(viewModelScope, it, object : RequestCallback<SearchModel> {
                override fun onSuccess(result: ResponseSuccess<SearchModel>) {
                    showLoading.value = false
                    getAdapter().clear()
                    result.data?.let { searchModel ->
                        getAdapter().addData(searchModel.items)
                    }
                }

                override fun onError(error: ResponseError) {
                    showLoading.value = false
                }
            })
        }
    }

    fun getAdapter() = adapter

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