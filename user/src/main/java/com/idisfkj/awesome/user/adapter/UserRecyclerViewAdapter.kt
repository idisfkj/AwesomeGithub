package com.idisfkj.awesome.user.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewAdapter
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewVH
import com.idisfkj.awesome.basic.recyclerview.CommonRecyclerViewVH
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.common.model.TYPE_INFO
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.user.BR
import com.idisfkj.awesome.user.R
import com.idisfkj.awesome.user.databinding.UserItemUserInfoLayoutBinding
import com.idisfkj.awesome.user.vm.UserInfoVM
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserRecyclerViewAdapter @Inject constructor(val vm: UserInfoVM) : BaseRecyclerViewAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return when (viewType) {
            TYPE_INFO -> CommonRecyclerViewVH<UserItemUserInfoLayoutBinding, UserModel>(
                parent,
                R.layout.user_item_user_info_layout,
                vm,
                BR.vm
            )
            else -> super.onCreateViewHolder(parent, viewType)
        }
    }
}