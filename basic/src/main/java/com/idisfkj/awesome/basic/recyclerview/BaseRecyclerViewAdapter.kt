package com.idisfkj.awesome.basic.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * recyclerView adapter
 * Created by idisfkj on 2019-09-03.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerViewAdapter :
    RecyclerView.Adapter<BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>>() {

    private val mData = arrayListOf<BaseRecyclerViewModel>()

    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return object :
            BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>(
                View(parent.context), null, 0
            ) {}
    }

    override fun onBindViewHolder(
        holder: BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>,
        position: Int
    ) {
        holder.bind(mData[position])
    }

    override fun getItemViewType(position: Int): Int = mData[position].itemType

    fun addData(item: BaseRecyclerViewModel) {
        mData.add(item)
        notifyItemInserted(mData.size - 1)
    }

    fun addData(list: List<BaseRecyclerViewModel>) {
        mData.addAll(list)
        notifyItemRangeInserted(mData.size - list.size, list.size)
    }

    fun clear() {
        mData.clear()
        notifyItemRangeRemoved(0, mData.size)
    }
}