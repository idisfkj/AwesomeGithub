package com.idisfkj.awesome.basic.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.utils.LoadingUtils

/**
 * Created by idisfkj on 2020/7/9.
 * Email: idisfkj@gmail.com.
 */
abstract class BaseHiltActivity<V : ViewDataBinding, M : BaseVM> : AppCompatActivity() {

    protected lateinit var viewDataBinding: V

    protected val viewModel: M by lazy { ViewModelProvider(this)[getViewModelClass()] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewDataBinding.setVariable(getVariableId(), viewModel)
        viewModel.attach(savedInstanceState)
        viewDataBinding.lifecycleOwner = this
        addObserver()
    }

    open fun addObserver() {
        viewModel.showLoading.observe(this, Observer {
            LoadingUtils.loading(it, viewDataBinding.root as? ViewGroup)
        })
    }

    abstract fun getVariableId(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelClass(): Class<M>

    protected fun hideSoftInput() {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            window.decorView.windowToken,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }

    protected fun showSoftInput(view: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }
}
