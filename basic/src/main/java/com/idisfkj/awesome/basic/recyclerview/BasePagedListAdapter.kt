package com.idisfkj.awesome.basic.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * support paged recyclerView adapter
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BasePagedListAdapter<T : BaseRecyclerViewModel>(
    callback: DiffUtil.ItemCallback<T> = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            areContentsTheSame(oldItem, newItem)

    },
    areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
    areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
) : PagedListAdapter<T, BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>>(callback) {

    override fun onBindViewHolder(holder: BaseRecyclerViewVH<ViewDataBinding, BaseRecyclerViewModel>, position: Int) {
        holder.bind(getItem(position))
    }

}
