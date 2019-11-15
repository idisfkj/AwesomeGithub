package com.idisfkj.awesome.basic.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.idisfkj.awesome.basic.BaseRecyclerVM
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * Created by idisfkj on 2019-11-14.
 * Email: idisfkj@gmail.com.
 */
class CommonRecyclerViewVH<out VB : ViewDataBinding, out M : BaseRecyclerViewModel> :
    BaseRecyclerViewVH<VB, M> {

    constructor(
        view: ViewGroup, @LayoutRes layoutId: Int,
        vm: BaseRecyclerVM<M>?,
        variableId: Int
    ) : super(LayoutInflater.from(view.context).inflate(layoutId, view, false), vm, variableId)

    constructor(view: View, vm: BaseRecyclerVM<M>?, variableId: Int) : super(view, vm, variableId)

}