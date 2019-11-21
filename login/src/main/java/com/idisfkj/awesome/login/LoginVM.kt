package com.idisfkj.awesome.login

import android.os.Bundle
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Base64
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.LoginToAuthorize
import com.idisfkj.awesome.common.LoginToMain
import com.idisfkj.awesome.common.PageDefault
import com.idisfkj.awesome.common.ToPageStatus
import com.idisfkj.awesome.common.extensions.createTextWatcher
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
class LoginVM(private val repository: LoginRepository) : BaseVM() {

    val username = MutableLiveData<String>(CommonUtils.getUsername())
    val password = MutableLiveData<String>(CommonUtils.getPassword())
    val signInEnable = MutableLiveData<Boolean>(false)
    val hideSoftInput = MutableLiveData(false)
    val toPage = MutableLiveData<ToPageStatus>(PageDefault)
    private var mUserJob: Job? = null
    private var mTokenJob: Job? = null

    override fun attach(savedInstanceState: Bundle?) {
    }

    override fun onCleared() {
        super.onCleared()
        mUserJob?.cancel()
        mTokenJob?.cancel()
    }

    fun usernameTextChangedListener(): TextWatcher =
        createTextWatcher({
            username.value = it.toString()
            signInEnable.value = !TextUtils.isEmpty(it) && !TextUtils.isEmpty(password.value)
        })

    fun passwordTextChangedListener(): TextWatcher =
        createTextWatcher({
            password.value = it.toString()
            signInEnable.value = !TextUtils.isEmpty(it) && !TextUtils.isEmpty(username.value)
        })

    fun addActionListener(): TextView.OnEditorActionListener =
        TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideSoftInput.value = true
                loginFromUsername()
                true
            } else {
                false
            }
        }

    fun signInClick() {
        showLoading.value = true
        loginFromUsername()
    }

    fun authorizeClick() {
        toPage.value = LoginToAuthorize
    }

    private fun loginFromUsername() {
        SPUtils.putString(SPUtils.KEY_USER_NAME, username.value ?: "")
        SPUtils.putString(SPUtils.KEY_PASSWORD, password.value ?: "")
        repository.appBridge.setAuthorizationBasic(
            Base64.encodeToString(
                (username.value + ":" + password.value).toByteArray(), Base64.NO_WRAP
            )
        )
        getUser()
    }

    private fun getUser() {
        mUserJob = request(handler = CoroutineExceptionHandler(({ _, _ ->
            showLoading.value = false
        }))) {
            repository.getUser()
            showLoading.postValue(false)
            toPage.postValue(LoginToMain)
        }
    }

    fun getAccessTokenFromCode(code: String) {
        showLoading.value = true
        mTokenJob = request(handler = CoroutineExceptionHandler(({ _, _ ->
            showLoading.value = false
        }))) {
            repository.getAccessToken(code) {
                getUser()
            }
        }
    }
}
