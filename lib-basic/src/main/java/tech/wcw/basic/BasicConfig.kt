package tech.wcw.basic

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:25
 * @Description:
 */
class BasicConfig {
    companion object {
        private var mInited = false;
        lateinit var BaseUrl: String;
        internal const val DEFAULT_TIMEOUT = 5000L

        @JvmStatic
        fun initialize(BaseUrl: String) {
            this.BaseUrl = BaseUrl
            if (mInited) {
                throw IllegalStateException("basic initialize has been called")
            }
            Logger.addLogAdapter(AndroidLogAdapter())

            mInited = true
        }

        @JvmStatic
        fun isInited(): Boolean {
            return mInited
        }
    }
}