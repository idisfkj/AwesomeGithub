package com.idisfkj.awesome.common.utils

import android.view.ViewGroup
import com.idisfkj.awesome.common.custom.LoadingView

/**
 * Created by idisfkj on 2019-11-13.
 * Email: idisfkj@gmail.com.
 */
object LoadingUtils {

    fun loading(show: Boolean, target: ViewGroup?) {
        if (show) showLoading(target) else dismissLoading(target)
    }

    private fun showLoading(target: ViewGroup?) {
        target?.run {
            if (childCount <= 0 || getChildAt(childCount - 1) !is LoadingView) {
                addView(LoadingView(context))
            }
        }
    }

    private fun dismissLoading(target: ViewGroup?) {
        target?.run {
            if (childCount > 0 && getChildAt(childCount - 1) is LoadingView) {
                removeViewAt(childCount - 1)
            }
        }
    }
}