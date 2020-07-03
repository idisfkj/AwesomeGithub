package com.idisfkj.awesome.search.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.idisfkj.awesome.basic.fragment.BaseDaggerFragment
import com.idisfkj.awesome.search.BR
import com.idisfkj.awesome.search.R
import com.idisfkj.awesome.search.SearchFragmentComponentFactory
import com.idisfkj.awesome.search.databinding.SearchFragmentSearchLayoutBinding
import com.idisfkj.awesome.search.fragment.di.SearchFragmentProviderModule
import com.idisfkj.awesome.search.vm.SearchVM

/**
 * Created by idisfkj on 2019-12-01.
 * Email: idisfkj@gmail.com.
 */
class SearchFragment : BaseDaggerFragment<SearchFragmentSearchLayoutBinding, SearchVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.search_fragment_search_layout

    override fun getViewModelClass(): Class<SearchVM> = SearchVM::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity().application as SearchFragmentComponentFactory).searchFragmentComponentFactory()
            .create(SearchFragmentProviderModule(lifecycleScope)).inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun getInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}