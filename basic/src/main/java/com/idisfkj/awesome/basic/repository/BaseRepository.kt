package com.idisfkj.awesome.basic.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
abstract class BaseRepository(var scope: CoroutineScope = CoroutineScope(Dispatchers.Main))

