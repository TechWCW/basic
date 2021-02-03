package tech.wcw.basic.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 17:32
 * @Description:
 */
open class BaseViewModel : ViewModel(), Repository {
    lateinit var mLifecycleOwner: WeakReference<LifecycleOwner>

    /**
     * 使用viewModelScope执行协程
     */

    fun injectLifecycle(lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = WeakReference(lifecycleOwner)
    }
}