package com.idisfkj.awesome.basic.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerViewVH<out VB : ViewDataBinding, out M : BaseRecyclerViewModel> :
    RecyclerView.ViewHolder {

    private var mViewDataBinding: ViewDataBinding? = null
    private var mVM: BaseRecyclerVM<M>? = null
    private var mVariableId: Int = 0

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int, vm: BaseRecyclerVM<M>?, variableId: Int) : super(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    ) {
        mVM = vm
        mVariableId = variableId
    }

    constructor(view: View, vm: BaseRecyclerVM<M>?, variableId: Int) : super(view) {
        mVM = vm
        mVariableId = variableId
    }

    init {
        mViewDataBinding = DataBindingUtil.bind<VB>(itemView)
    }

    open fun bind(data: BaseRecyclerViewModel?) {
        mViewDataBinding?.setVariable(mVariableId, mVM)
        @Suppress("UNCHECKED_CAST")
        mVM?.onBind(data as M?)
        mViewDataBinding?.executePendingBindings()
    }

}
