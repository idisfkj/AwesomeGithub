package com.idisfkj.awesome.search.fragment

import com.idisfkj.awesome.basic.fragment.BaseHiltFragment
import com.idisfkj.awesome.search.BR
import com.idisfkj.awesome.search.R
import com.idisfkj.awesome.search.databinding.SearchFragmentSearchLayoutBinding
import com.idisfkj.awesome.search.vm.SearchVM
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
@AndroidEntryPoint
class SearchFragment : BaseHiltFragment<SearchFragmentSearchLayoutBinding, SearchVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.search_fragment_search_layout

    override fun getViewModelClass(): Class<SearchVM> = SearchVM::class.java

    companion object {
        fun getInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}