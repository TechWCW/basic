package tech.wcw.simple.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import okhttp3.ResponseBody
import tech.wcw.basic.api
import tech.wcw.basic.retrofitCallLiveData
import tech.wcw.simple.api.Api

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:40
 * @Description:
 */
class BaiduRepository {
    companion object {
        var baidu: LiveData<ResponseBody> = retrofitCallLiveData {
            api(Api::class.java).baidu(

            )
        }
    }
}