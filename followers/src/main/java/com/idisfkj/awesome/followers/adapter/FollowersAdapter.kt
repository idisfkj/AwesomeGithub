package com.idisfkj.awesome.followers.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewVH
import com.idisfkj.awesome.basic.recyclerview.CommonRecyclerViewVH
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.followers.BR
import com.idisfkj.awesome.followers.R
import com.idisfkj.awesome.followers.vm.FollowersVHVM

/**
 * Created by idisfkj on 2019-11-22.
 * Email : idisfkj@gmail.com.
 */
class FollowersAdapter : BaseRecyclerViewAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return CommonRecyclerViewVH(
            parent,
            R.layout.followers_item_followers_layout,
            FollowersVHVM(parent.context),
            BR.vm
        )
    }
}