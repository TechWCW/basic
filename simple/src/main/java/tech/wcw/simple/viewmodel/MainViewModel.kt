package tech.wcw.simple.viewmodel

import androidx.databinding.ObservableField
import tech.wcw.basic.base.BaseViewModel
import tech.wcw.simple.repository.BaiduRepository

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2020/11/24 16:38
 * @Description:
 */
class MainViewModel : BaseViewModel() {
    var msg: ObservableField<String> = ObservableField();

    fun baidu() {
        mLifecycleOwner.get()?.let {
            BaiduRepository.baidu.observe(it, {
                msg.set(String(it.bytes()))
            })
        }
    }
}