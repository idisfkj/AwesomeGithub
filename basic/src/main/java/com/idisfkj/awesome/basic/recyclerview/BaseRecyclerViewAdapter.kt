package com.idisfkj.awesome.basic.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * recyclerView adapter
 * Created by idisfkj on 2019-09-03.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerViewAdapter(
    private val outerLifecycle: Lifecycle? = null,
    private val useDiffUtil: Boolean = false
) : RecyclerView.Adapter<BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>>() {

    private val mCallback = object : DiffUtil.Callback() {
       
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            areItemsTheSame(mOldData[oldItemPosition], mData[newItemPosition])

        override fun getOldListSize(): Int = mOldData.size

        override fun getNewListSize(): Int = mData.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            areContentsTheSame(mOldData[oldItemPosition], mData[newItemPosition])
    }

    private val mData = arrayListOf<BaseRecyclerViewModel>()
    private val mOldData = arrayListOf<BaseRecyclerViewModel>()

    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel> {
        return CommonRecyclerViewVH(View(parent.context), null, 0, outerLifecycle)
    }

    override fun onBindViewHolder(
        holder: BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>,
        position: Int
    ) {
        holder.bind(mData[position])
    }

    override fun getItemViewType(position: Int): Int = mData[position].itemType

    fun addData(item: BaseRecyclerViewModel) {
        addData(arrayListOf(item))
    }

    fun addData(list: List<BaseRecyclerViewModel>) {
        mData.addAll(list)
        if (useDiffUtil) {
            DiffUtil.calculateDiff(mCallback).apply {
                dispatchUpdatesTo(this@BaseRecyclerViewAdapter)
                mOldData.addAll(list)
            }
        } else {
            notifyItemRangeInserted(mData.size - list.size, list.size)
        }
    }

    fun clear() {
        mData.clear()
        mOldData.clear()
        notifyDataSetChanged()
    }

    open fun areItemsTheSame(
        oldItem: BaseRecyclerViewModel,
        newItem: BaseRecyclerViewModel
    ): Boolean = false

    open fun areContentsTheSame(
        oldItem: BaseRecyclerViewModel,
        newItem: BaseRecyclerViewModel
    ): Boolean = false

}