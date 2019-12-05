package com.idisfkj.awesome.basic.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.basic.lifecycle.VHLifecycleObserver
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerViewVH<out VB : ViewDataBinding, out M : BaseRecyclerViewModel> :
    RecyclerView.ViewHolder, LifecycleOwner {

    private var mViewDataBinding: VB? = null
    private var mVM: BaseRecyclerVM<M>? = null
    private var mVariableId: Int = 0
    private lateinit var mLifecycle: LifecycleRegistry
    private var mOuterLifecycle: Lifecycle? = null

    constructor(
        parent: ViewGroup, @LayoutRes layoutId: Int,
        vm: BaseRecyclerVM<M>?,
        variableId: Int,
        outerLifecycle: Lifecycle? = null
    ) : super(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    ) {
        init(vm, variableId, outerLifecycle)
    }

    constructor(
        view: View,
        vm: BaseRecyclerVM<M>?,
        variableId: Int,
        outerLifecycle: Lifecycle? = null
    ) : super(view) {
        init(vm, variableId, outerLifecycle)
    }

    init {
        mViewDataBinding = DataBindingUtil.bind(itemView)
    }

    private fun init(vm: BaseRecyclerVM<M>?, variableId: Int, outerLifecycle: Lifecycle?) {
        mVM = vm
        mVariableId = variableId
        mOuterLifecycle = outerLifecycle
        register()
    }

    private fun register() {
        mLifecycle = LifecycleRegistry(this)
        mOuterLifecycle?.let {
            it.addObserver(VHLifecycleObserver(it, mLifecycle))
            mViewDataBinding?.lifecycleOwner = this
        }
    }

    open fun bind(data: BaseRecyclerViewModel?) {
        mViewDataBinding?.setVariable(mVariableId, mVM)
        @Suppress("UNCHECKED_CAST")
        mVM?.onBind(data as M?)
        mViewDataBinding?.executePendingBindings()
    }

    override fun getLifecycle(): Lifecycle = mLifecycle
}
