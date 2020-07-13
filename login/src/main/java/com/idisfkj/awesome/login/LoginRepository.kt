package com.idisfkj.awesome.login

import com.idisfkj.awesome.basic.repository.BaseRepository
import com.idisfkj.awesome.common.Constants
import com.idisfkj.awesome.common.extensions.RequestCallback
import com.idisfkj.awesome.common.extensions.request
import com.idisfkj.awesome.common.model.UserModel
import com.idisfkj.awesome.common.utils.CommonUtils
import com.idisfkj.awesome.network.GithubService
import com.idisfkj.awesome.network.HttpClient
import kotlinx.coroutines.CoroutineScope
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
class LoginRepository @Inject constructor(
    private val service: GithubService
) : BaseRepository() {

    fun getUser(scope: CoroutineScope, callback: RequestCallback<UserModel>) {
        request(scope, callback) {
            service.getUser()
        }
    }

    fun getAccessToken(scope: CoroutineScope, code: String, callback: RequestCallback<Response<ResponseBody>>) {
        request(scope, callback) {
            HttpClient.getServiceFromBaseUrl(HttpClient.GITHUB_BASE_URL).getAccessToken(
                CommonUtils.parseToJsonObject(
                    TokenRequestModel(
                        Constants.CLIENT_ID,
                        Constants.CLIENT_SECRET,
                        code,
                        Constants.REDIRECT_URI
                    )
                )
            )
        }
    }
}
