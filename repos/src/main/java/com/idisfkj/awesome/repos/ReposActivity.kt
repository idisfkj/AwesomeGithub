package com.idisfkj.awesome.repos

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.idisfkj.awesome.basic.activity.BaseDaggerActivity
import com.idisfkj.awesome.common.ARouterPaths
import com.idisfkj.awesome.repos.databinding.ReposActivityMainLayoutBinding
import com.idisfkj.awesome.repos.di.ReposProviderModule
import com.idisfkj.awesome.repos.vm.ReposVM

/**
 * Created by idisfkj on 2019-11-19.
 * Email: idisfkj@gmail.com.
 */
@Route(path = ARouterPaths.PATH_REPOS_REPOS)
class ReposActivity : BaseDaggerActivity<ReposActivityMainLayoutBinding, ReposVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.repos_activity_main_layout

    override fun getViewModelClass(): Class<ReposVM> = ReposVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ReposComponentFactory).reposComponentFactory().create(ReposProviderModule(lifecycleScope)).inject(this)
        super.onCreate(savedInstanceState)
    }

}