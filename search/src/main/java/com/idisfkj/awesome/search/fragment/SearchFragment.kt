package com.idisfkj.awesome.search.fragment

import com.idisfkj.awesome.basic.fragment.BaseFragment
import com.idisfkj.awesome.search.BR
import com.idisfkj.awesome.search.R
import com.idisfkj.awesome.search.databinding.SearchFragmentSearchLayoutBinding
import com.idisfkj.awesome.search.vm.SearchVM

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
class SearchFragment : BaseFragment<SearchFragmentSearchLayoutBinding, SearchVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.search_fragment_search_layout

    override fun getViewModelInstance(): SearchVM = SearchVM()

    override fun getViewModelClass(): Class<SearchVM> = SearchVM::class.java

    companion object {
        fun getInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}