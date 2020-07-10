package com.idisfkj.awesome.basic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.utils.LoadingUtils
import timber.log.Timber

/**
 * Created by idisfkj on 2020/7/10.
 * Email: idisfkj@gmail.com.
 */
abstract class BaseHiltFragment<V : ViewDataBinding, M : BaseVM> : Fragment() {

    protected lateinit var viewDataBinding: V
    protected val viewModel: M by lazy { ViewModelProvider(this)[getViewModelClass()] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("$this: onCreateView")
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setVariable(getVariableId(), viewModel)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("$this: onViewCreated")
        addObserver()
        viewModel.attach(savedInstanceState)
    }

    open fun addObserver() {
        viewModel.showLoading.observe(viewLifecycleOwner, Observer {
            LoadingUtils.loading(it, viewDataBinding.root as? ViewGroup)
        })
    }

    abstract fun getVariableId(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelClass(): Class<M>

}
