package com.idisfkj.awesome.home.fragment.vh

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.idisfkj.awesome.basic.recyclerview.BaseRecyclerViewVH
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.home.BR
import com.idisfkj.awesome.home.fragment.vm.HomeUserInfoVM
import kotlinx.android.synthetic.main.home_item_user_info_layout.view.*

/**
 * Created by idisfkj on 2019-09-03.
 * Email : idisfkj@gmail.com.
 */
class HomeUserInfoVH<VB : ViewDataBinding>(parent: ViewGroup, @LayoutRes layoutId: Int, vm: HomeUserInfoVM) :
    BaseRecyclerViewVH<VB, UserModel>(parent, layoutId, vm, BR.vm) {

    @SuppressLint("SetTextI18n")
    override fun bind(data: BaseRecyclerViewModel?) {
        with(itemView) {
            (data as? UserModel)?.let {
                Glide.with(this).load(it.avatar_url).into(user_avatar)
                if (it.name == it.login) {
                    user_name.text = it.name
                } else {
                    user_name.text = it.name + "(${it.login})"
                }
                user_bio.text = it.bio
                user_location.text = it.location

                user_public_repos.text = it.public_repos.toString()
                user_public_gits.text = it.public_repos.toString()
                user_followers.text = it.followers.toString()
                user_following.text = it.following.toString()
            }
        }
    }
}