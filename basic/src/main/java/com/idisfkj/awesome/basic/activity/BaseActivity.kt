package com.idisfkj.awesome.basic.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.idisfkj.awesome.basic.BaseVM

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseActivity<V : ViewDataBinding, M : BaseVM> : AppCompatActivity() {

    protected lateinit var viewDataBinding: V

    protected lateinit var viewModel: M


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return getViewModelInstance() as T
            }
        })[getViewModelClass()]
        viewDataBinding.setVariable(getVariableId(), viewModel)
        viewModel.attach(savedInstanceState)
        viewDataBinding.lifecycleOwner = this
    }

    abstract fun getVariableId(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelInstance(): M

    abstract fun getViewModelClass(): Class<M>

    protected fun hideSoftInput() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            window.decorView.windowToken,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }

    protected fun showSoftInput(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }
}
