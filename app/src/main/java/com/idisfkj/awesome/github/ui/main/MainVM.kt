package com.idisfkj.awesome.github.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.viewpager.widget.PagerAdapter
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.github.R
import com.idisfkj.awesome.login.IssuesRequestModel
import com.idisfkj.awesome.network.HttpClient
import timber.log.Timber

/**
 * Created by idisfkj on 2019-08-12.
 * Email : idisfkj@gmail.com.
 */
class MainVM @ViewModelInject constructor(private val mainViewPagerAdapter: MainViewPagerAdapter) : BaseVM() {

    companion object {
        private const val HOME_POS = 0
        private const val REPOSITORY_POS = 1
        private const val USER_POS = 2
    }

    private var mBackTime = 0L
    private var mBackIntervalTime = 2500L
    val selectedPosition = MutableLiveData<Int>(HOME_POS)

    override fun attach(savedInstanceState: Bundle?) {
//        getProps()
//        createIssues()
    }

    fun createAdapter(): PagerAdapter = mainViewPagerAdapter

    fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.home -> selectedPosition.value = HOME_POS
            R.id.repository -> selectedPosition.value = REPOSITORY_POS
            R.id.user -> selectedPosition.value = USER_POS
            else -> return false

        }
        return true
    }

    private fun getProps() {
        request(viewModelScope) {
            val responseBody = HttpClient.getService().getPros(CommonUtils.getRealUserName()).body()
            Timber.d("getProps %s", responseBody?.size)
        }
    }

    private fun createIssues() {
        request(viewModelScope) {
            val issuesModel = HttpClient.getService().createIssues(
                CommonUtils.getRealUserName(), "github-test",
                CommonUtils.parseToJsonObject(IssuesRequestModel("Issues Test"))
            )
            Timber.d("createIssue onResponse %s", issuesModel.title)
        }
    }

    fun exitApp(): Boolean {
        if (System.currentTimeMillis() - mBackTime <= mBackIntervalTime) {
            return true
        }
        mBackTime = System.currentTimeMillis()
        return false
    }

}