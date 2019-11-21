package com.idisfkj.awesome.home.fragment.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewVH
import com.idisfkj.awesome.basic.recyclerview.CommonRecyclerViewVH
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.home.BR
import com.idisfkj.awesome.home.R
import com.idisfkj.awesome.home.databinding.HomeItemUserInfoLayoutBinding
import com.idisfkj.awesome.home.fragment.vm.HomeUserInfoVM

/**
 * Created by idisfkj on 2019-09-03.
 * Email : idisfkj@gmail.com.
 */
class HomeRecyclerViewAdapter : BaseRecyclerViewAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return when (viewType) {
            TYPE_INFO -> CommonRecyclerViewVH<HomeItemUserInfoLayoutBinding, UserModel>(
                parent,
                R.layout.home_item_user_info_layout,
                HomeUserInfoVM(), BR.vm
            )
            else -> super.onCreateViewHolder(parent, viewType)
        }
    }
}