package com.idisfkj.awesome.basic

import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.common.utils.CommonUtils

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseVM : AndroidViewModel(CommonUtils.getApp()) {

    val showLoading = MutableLiveData<Boolean>(false)

    abstract fun attach(savedInstanceState: Bundle? = null)

}
