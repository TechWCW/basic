package tech.wcw.basic

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.HttpException
import tech.wcw.basic.BasicConfig.Companion.DEFAULT_TIMEOUT
import tech.wcw.basic.base.CallBack
import tech.wcw.basic.base.DefaultCallBack
import tech.wcw.basic.net.RetrofitFactory
import kotlin.coroutines.CoroutineContext

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:35
 * @Description:
 */
fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}

fun <T> Any.api(
    clazz: Class<T>,
    baseUrl: String = BasicConfig.BaseUrl
): T {
    return RetrofitFactory.getRetrofit(baseUrl).create(clazz)
}


/**
 * 使用对返回类型为Call<*>的封装，即block: suspend () -> Call<T>
 * 使用时retrofitCallLiveData{
 *      --Api请求--
 * }
 * 返回结果为LiveData
 *
 */
fun <T> retrofitCallLiveData(
    context: CoroutineContext = Dispatchers.IO,
    timeoutInMs: Long = DEFAULT_TIMEOUT,
    callBack: CallBack<T> = DefaultCallBack(),
    block: suspend () -> Call<T>
): LiveData<T> {
    return liveData<T>(context, timeoutInMs) {
        runCatching {
            val response = block().execute()
            if (response.isSuccessful) {
                emit(response.body()!!)
            } else {
                throw HttpException(response)
            }
            return@runCatching response
        }.onFailure {
            it.printStackTrace()
            callBack.onFailure(it)
        }
    }
}

/**
 * 返回类型为*的
 */
fun <T> retrofitLiveData(
    context: CoroutineContext = Dispatchers.IO,
    timeoutInMs: Long = DEFAULT_TIMEOUT,
    callBack: CallBack<T> = DefaultCallBack(),
    block: suspend () -> T
): LiveData<T> {
    return liveData<T>(context, timeoutInMs) {
        runCatching {
            val ret = block()
            emit(ret)
        }.onFailure {
            it.printStackTrace()
            callBack.onFailure(it)
        }
    }
}
