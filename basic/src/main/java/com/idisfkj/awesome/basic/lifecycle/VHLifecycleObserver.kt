package com.idisfkj.awesome.basic.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by idisfkj on 2019-12-05.
 * Email : idisfkj@gmail.com.
 */
class VHLifecycleObserver(
    private val outerLifecycle: Lifecycle,
    private val lifecycleRegistry: LifecycleRegistry
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        if (outerLifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        if (outerLifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
            lifecycleRegistry.currentState = Lifecycle.State.CREATED
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}