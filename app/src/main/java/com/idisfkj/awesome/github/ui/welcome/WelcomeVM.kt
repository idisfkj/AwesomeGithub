package com.idisfkj.awesome.github.ui.welcome

import android.os.Bundle
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.PageDefault
import com.idisfkj.awesome.common.ToPageStatus
import com.idisfkj.awesome.common.WelcomeToLogin
import com.idisfkj.awesome.common.WelcomeToMain
import com.idisfkj.awesome.common.utils.CommonUtils
import java.util.*

/**
 * Created by idisfkj on 2019-08-13.
 * Email : idisfkj@gmail.com.
 */
class WelcomeVM @ViewModelInject constructor() : BaseVM() {

    val toPage = MutableLiveData<ToPageStatus>(PageDefault)
    private var mTimer: Timer? = null

    override fun attach(savedInstanceState: Bundle?) {
        startDelay()
    }

    override fun onCleared() {
        super.onCleared()
        mTimer?.cancel()
        mTimer = null
    }

    private fun startDelay() {
        mTimer = Timer().apply {
            schedule(object : TimerTask() {
                override fun run() {
                    mTimer = null
                    toPage.postValue(if (CommonUtils.hasLogin()) WelcomeToMain else WelcomeToLogin)
                }

            }, 1500)
        }
    }
}