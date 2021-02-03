package tech.wcw.simple.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2020/11/24 16:39
 * @Description:
 */
interface Api {

    @GET("https://www.baidu.com")
    fun baidu(): Call<ResponseBody>
}