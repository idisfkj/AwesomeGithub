package com.idisfkj.awesome.repos

import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.repos.databinding.ReposActivityMainLayoutBinding
import com.idisfkj.awesome.repos.repository.ReposRepository
import com.idisfkj.awesome.repos.vm.ReposVM

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_REPOS_REPOS)
class ReposActivity : BaseActivity<ReposActivityMainLayoutBinding, ReposVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.repos_activity_main_layout

    override fun getViewModelInstance(): ReposVM =
        ReposVM(application, ReposRepository(HttpClient.getService()))

    override fun getViewModelClass(): Class<ReposVM> = ReposVM::class.java

    override fun addObserver() {
        super.addObserver()
    }

}