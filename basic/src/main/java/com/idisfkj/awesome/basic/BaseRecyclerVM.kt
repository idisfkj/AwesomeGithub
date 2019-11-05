package com.idisfkj.awesome.basic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.idisfkj.awesome.common.model.BaseRecyclerViewModel

/**
 * Created by idisfkj on 2019-09-04.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRecyclerVM<in T : BaseRecyclerViewModel>(app: Application) : AndroidViewModel(app) {

    abstract fun onBind(model: T?)
}