package com.idisfkj.awesome.user.fragment

import androidx.lifecycle.Observer
import com.idisfkj.awesome.basic.fragment.BaseFragment
import com.idisfkj.awesome.common.UserToFollowers
import com.idisfkj.awesome.common.UserToRepos
import com.idisfkj.awesome.componentbridge.followers.FollowersBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.componentbridge.repos.ReposBridgeInterface
import com.idisfkj.awesome.network.HttpClient
import com.idisfkj.awesome.user.BR
import com.idisfkj.awesome.user.R
import com.idisfkj.awesome.user.databinding.UserFragmentUserBinding
import com.idisfkj.awesome.user.repository.UserRepository
import com.idisfkj.awesome.user.vm.UserInfoVM
import com.idisfkj.awesome.user.vm.UserVM
import timber.log.Timber

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserFragment : BaseFragment<UserFragmentUserBinding, UserVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.user_fragment_user

    override fun getViewModelInstance(): UserVM =
        UserVM(UserRepository(HttpClient.getService()), UserInfoVM())

    override fun getViewModelClass(): Class<UserVM> = UserVM::class.java

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.userData.observe(this, Observer {
            Timber.d("addObserver %s", it.followers)
        })
        viewModel.userInfoVM.navigate.observe(this, Observer {
            if (it is UserToRepos) {
                BridgeProviders.instance.getBridge(ReposBridgeInterface::class.java)
                    .toReposActivity(requireContext())
            } else if (it is UserToFollowers) {
                BridgeProviders.instance.getBridge(FollowersBridgeInterface::class.java)
                    .toFollowersActivity(requireContext())
            }
        })
    }
}