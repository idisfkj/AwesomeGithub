package com.idisfkj.awesome.login

import android.os.Bundle
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Base64
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idisfkj.awesome.basic.BaseVM
import com.idisfkj.awesome.common.LoginToAuthorize
import com.idisfkj.awesome.common.LoginToMain
import com.idisfkj.awesome.common.PageDefault
import com.idisfkj.awesome.common.ToPageStatus
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.createTextWatcher
import com.idisfkj.awesome.common.model.ResponseError
import com.idisfkj.awesome.common.model.ResponseSuccess
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.network.HttpClient
import kotlinx.coroutines.Job
import okhttp3.ResponseBody
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
class LoginVM @ViewModelInject constructor(
    private val appBridge: AppBridgeInterface,
    private val repository: LoginRepository
) : BaseVM() {

    val username = MutableLiveData<String>(CommonUtils.getUsername())
    val password = MutableLiveData<String>(CommonUtils.getPassword())
    val signInEnable = MutableLiveData<Boolean>(false)
    val hideSoftInput = MutableLiveData(false)
    val toPage = MutableLiveData<ToPageStatus>(PageDefault)
    private var mTokenJob: Job? = null

    override fun attach(savedInstanceState: Bundle?) {
    }

    override fun onCleared() {
        super.onCleared()
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
        appBridge.setAuthorizationBasic(
            Base64.encodeToString(
                (username.value + ":" + password.value).toByteArray(), Base64.NO_WRAP
            )
        )
        getUser()
    }

    private fun getUser() {
        repository.getUser(viewModelScope, object : RequestCallback<UserModel> {
            override fun onSuccess(result: ResponseSuccess<UserModel>) {
                val user = result.data
                Timber.d("getUser %s", user?.login)
                // login success, save user info
                SPUtils.putString(SPUtils.KEY_REAL_USER_NAME, user?.login)
                SPUtils.putString(
                    SPUtils.KEY_AUTHORIZATION_BASIC,
                    appBridge.getAuthorizationBasic()
                )
                SPUtils.putString(SPUtils.KEY_ACCESS_TOKEN, appBridge.getAccessToken())
                showLoading.postValue(false)
                toPage.postValue(LoginToMain)
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
            }

        })
    }

    fun getAccessTokenFromCode(code: String) {
        showLoading.value = true
        repository.getAccessToken(viewModelScope, code, object : RequestCallback<Response<ResponseBody>> {
            override fun onSuccess(result: ResponseSuccess<Response<ResponseBody>>) {
                try {
                    appBridge.setAccessToken(
                        result.data?.body()?.string()?.split("=")?.get(1)?.split("&")?.get(
                            0
                        )
                    )
                    getUser()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onError(error: ResponseError) {
                showLoading.value = false
            }
        })
    }
}
