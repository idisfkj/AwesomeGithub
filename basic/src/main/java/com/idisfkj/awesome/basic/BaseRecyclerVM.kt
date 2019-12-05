package com.idisfkj.awesome.basic

import androidx.lifecycle.AndroidViewModel
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel
import com.idisfkj.awesome.common.utils.CommonUtils

/**
 * Created by idisfkj on 2019-09-04.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerVM<in T : BaseRecyclerViewModel> :
    AndroidViewModel(CommonUtils.getApp()) {

    abstract fun onBind(model: T?)
}