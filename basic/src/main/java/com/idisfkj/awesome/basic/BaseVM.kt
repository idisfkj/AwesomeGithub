package com.idisfkj.awesome.basic

import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.idisfkj.awesome.common.live.SingleLiveEvent
import com.idisfkj.awesome.common.utils.CommonUtils

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseVM : AndroidViewModel(CommonUtils.getApp()) {

    val showLoading = SingleLiveEvent<Boolean>()

    abstract fun attach(savedInstanceState: Bundle? = null)

}
