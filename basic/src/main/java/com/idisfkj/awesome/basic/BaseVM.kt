package com.idisfkj.awesome.basic

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseVM(application: Application) : AndroidViewModel(application) {

    val showLoading = MutableLiveData<Boolean>(false)

    abstract fun attach(savedInstanceState: Bundle? = null)

}
