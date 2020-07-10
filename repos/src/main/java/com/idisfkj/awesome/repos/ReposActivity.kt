package com.idisfkj.awesome.repos

import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseActivity
import com.idisfkj.awesome.basic.activity.BaseHiltActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.repos.databinding.ReposActivityMainLayoutBinding
import com.idisfkj.awesome.repos.vm.ReposVM
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
@AndroidEntryPoint
@Route(path = ARouterPaths.PATH_REPOS_REPOS)
class ReposActivity : BaseHiltActivity<ReposActivityMainLayoutBinding, ReposVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.repos_activity_main_layout

    override fun getViewModelClass(): Class<ReposVM> = ReposVM::class.java

}