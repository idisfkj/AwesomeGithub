package com.idisfkj.awesome.user.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.idisfkj.awesome.basic.fragment.BaseDaggerFragment
import com.idisfkj.awesome.common.UserToFollowers
import com.idisfkj.awesome.common.UserToFollowing
import com.idisfkj.awesome.common.UserToRepos
import com.idisfkj.awesome.componentbridge.followers.FollowersBridgeInterface
import com.idisfkj.awesome.componentbridge.following.FollowingBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.user.BR
import com.idisfkj.awesome.user.R
import com.idisfkj.awesome.user.UserFragmentComponentFactory
import com.idisfkj.awesome.user.databinding.UserFragmentUserBinding
import com.idisfkj.awesome.user.fragment.di.UserFragmentProviderModule
import com.idisfkj.awesome.user.vm.UserVM
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserFragment : BaseDaggerFragment<UserFragmentUserBinding, UserVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.user_fragment_user

    override fun getViewModelClass(): Class<UserVM> = UserVM::class.java

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ((requireActivity().application as UserFragmentComponentFactory).userFragmentComponentFactory())
            .create(UserFragmentProviderModule(lifecycleScope)).inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.userData.observe(this, Observer {
            Timber.d("addObserver %s", it.followers)
        })
        viewModel.userInfoVM.navigate.observe(this, Observer {
            when (it) {
                is UserToRepos -> BridgeProviders.instance.getBridge(ReposBridgeInterface::class.java)
                    .toReposActivity(requireContext())
                is UserToFollowers -> BridgeProviders.instance.getBridge(FollowersBridgeInterface::class.java)
                    .toFollowersActivity(requireContext())
                is UserToFollowing -> BridgeProviders.instance.getBridge(FollowingBridgeInterface::class.java)
                    .toFollowingActivity(requireContext())
            }
        })
    }
}