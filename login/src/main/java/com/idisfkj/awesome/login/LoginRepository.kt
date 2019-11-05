package com.idisfkj.awesome.login

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.Constants
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.network.GithubService
import com.idisfkj.awesome.network.HttpClient
import timber.log.Timber
import java.io.IOException

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
class LoginRepository(
    val appBridge: AppBridgeInterface,
    private val service: GithubService
) : BaseRepository {

    suspend fun getUser() {
        val user = service.getUser()
        Timber.d("getUser %s", user.login)

        // login success, save user info
        SPUtils.putString(SPUtils.KEY_REAL_USER_NAME, user.login)
        SPUtils.putString(SPUtils.KEY_AUTHORIZATION_BASIC, appBridge.getAuthorizationBasic())
        SPUtils.putString(SPUtils.KEY_ACCESS_TOKEN, appBridge.getAccessToken())
    }

    suspend fun getAccessToken(code: String, block: () -> Unit) {
        val response = HttpClient.getServiceFromBaseUrl(HttpClient.GITHUB_BASE_URL).getAccessToken(
            CommonUtils.parseToJsonObject(
                TokenRequestModel(
                    Constants.CLIENT_ID,
                    Constants.CLIENT_SECRET,
                    code,
                    Constants.REDIRECT_URI
                )
            )
        )
        try {
            appBridge.setAccessToken(response.body()?.string()?.split("=")?.get(1)?.split("&")?.get(0))
            block()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
