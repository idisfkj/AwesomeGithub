package com.idisfkj.awesome.common.model

/**
 * Created by idisfkj on 2019-12-11.
 * Email : idisfkj@gmail.com.
 */
sealed class ResponseResult

data class ResponseSuccess<T>(val data: T?) : ResponseResult()
data class ResponseError(val t: Throwable?) : ResponseResult()