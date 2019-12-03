package com.idisfkj.awesome.webview.vm

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM

/**
 * Created by idisfkj on 2019-12-03.
 * Email: idisfkj@gmail.com.
 */
class WebViewVM: BaseVM() {

    val url = MutableLiveData<String>()

    override fun attach(savedInstanceState: Bundle?) {
    }
}