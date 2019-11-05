package com.idisfkj.awesome.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
object HttpClient {

    private const val API_GITHUB_BASE_URL = "https://api.github.com"
    const val GITHUB_BASE_URL = "https://github.com"
    private var sInstance: GithubService? = null
    private var gson: Gson? = null

    fun getService(): GithubService {
        if (sInstance == null) {
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .addNetworkInterceptor(GithubApiInterceptor())
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build()

            sInstance = Retrofit.Builder()
                .baseUrl(API_GITHUB_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)

        }
        return sInstance as GithubService
    }

    fun getServiceFromBaseUrl(baseUrl: String): GithubService {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addNetworkInterceptor(GithubApiInterceptor())
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)

    }

    fun createGson(): Gson {
        if (gson == null) {
            gson = Gson()
        }
        return gson!!
    }
}