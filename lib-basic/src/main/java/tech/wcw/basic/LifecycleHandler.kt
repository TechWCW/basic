package tech.wcw.basic

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:20
 * @Description:
 */
class LifecycleHandler : Handler, LifecycleObserver {
    var lifecycleOwner: LifecycleOwner

    constructor(lifecycleOwner: LifecycleOwner) : super() {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    constructor(lifecycleOwner: LifecycleOwner, callback: Callback?) : super(callback) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }


    constructor(lifecycleOwner: LifecycleOwner, looper: Looper, callback: Callback?) : super(
        looper,
        callback
    ) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    private fun addObserver() {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        removeCallbacksAndMessages(null)
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}