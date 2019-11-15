package com.idisfkj.awesome.user.fragment

import com.idisfkj.awesome.basic.fragment.BaseFragment
import com.idisfkj.awesome.user.BR
import com.idisfkj.awesome.user.R
import com.idisfkj.awesome.user.databinding.UserFragmentUserBinding
import com.idisfkj.awesome.user.vm.UserVM

/**
 * Created by idisfkj on 2019-11-15.
 * Email: idisfkj@gmail.com.
 */
class UserFragment : BaseFragment<UserFragmentUserBinding, UserVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.user_fragment_user

    override fun getViewModelInstance(): UserVM = UserVM(requireActivity().application)

    override fun getViewModelClass(): Class<UserVM> = UserVM::class.java

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }
}