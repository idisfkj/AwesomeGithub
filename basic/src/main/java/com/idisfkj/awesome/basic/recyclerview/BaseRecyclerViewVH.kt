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
import androidx.lifecycle.Observer
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

    private var mViewDataBinding: ViewDataBinding? = null
    private var mVM: BaseRecyclerVM<M>? = null
    private var mVariableId: Int = 0
    private lateinit var mLifecycleRegistry: LifecycleRegistry

    constructor(
        parent: ViewGroup, @LayoutRes layoutId: Int,
        vm: BaseRecyclerVM<M>?,
        variableId: Int
    ) : super(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    ) {
        mVM = vm
        mVariableId = variableId
        addObserve()
    }

    constructor(view: View, vm: BaseRecyclerVM<M>?, variableId: Int) : super(view) {
        mVM = vm
        mVariableId = variableId
        addObserve()
    }

    init {
        mViewDataBinding = DataBindingUtil.bind<VB>(itemView)
        register()
    }

    private fun register() {
        mLifecycleRegistry = LifecycleRegistry(this)
        mLifecycleRegistry.currentState = Lifecycle.State.CREATED
        mLifecycleRegistry.currentState = Lifecycle.State.STARTED
        lifecycle.addObserver(VHLifecycleObserver(lifecycle))
        mViewDataBinding?.lifecycleOwner = this
    }

    private fun addObserve() {
        mVM?.executePendingBindings?.observe(this, Observer {
            mViewDataBinding?.executePendingBindings()
        })
    }

    open fun bind(data: BaseRecyclerViewModel?) {
        mLifecycleRegistry.currentState = Lifecycle.State.RESUMED
        mViewDataBinding?.setVariable(mVariableId, mVM)
        @Suppress("UNCHECKED_CAST")
        mVM?.onBind(data as M?)
        mViewDataBinding?.executePendingBindings()
    }

    override fun getLifecycle(): Lifecycle = mLifecycleRegistry
}
