package com.idisfkj.awesome.basic

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseVM(application: Application) : AndroidViewModel(application) {

    abstract fun attach(savedInstanceState: Bundle? = null)

}
