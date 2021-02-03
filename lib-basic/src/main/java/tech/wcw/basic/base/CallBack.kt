package tech.wcw.basic.base


/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 17:47
 * @Description:
 */
interface CallBack<T> {
    //    fun onSuccess(t: T)
    fun onFailure(t: Throwable)
}

class DefaultCallBack<T> : CallBack<T> {
    override fun onFailure(t: Throwable) {
        t.printStackTrace()
    }

}