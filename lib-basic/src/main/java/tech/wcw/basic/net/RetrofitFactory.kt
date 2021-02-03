package tech.wcw.basic.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:20
 * @Description:
 */
class RetrofitFactory {
    companion object {
        @JvmField
        var cache: HashMap<String, Retrofit> = HashMap()

        @JvmStatic
        fun getRetrofit(baseUrl: String): Retrofit {
            var retrofit = cache[baseUrl]
            if (retrofit != null) {
                return retrofit
            }
            var builder: Retrofit.Builder = Retrofit.Builder();
            var interpolator: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
            val okHttpBuilder = OkHttpClient.Builder()
            okHttpBuilder
                .addInterceptor(interpolator)
                .dns(MyDNS())
                .build()
//            if (httpsEnable) {
//                okHttpBuilder.sslSocketFactory(
//                    HttpsHelper.sslSocketFactory(),
//                    HttpsHelper.trustManager()[0]
//                ).hostnameVerifier(HttpsHelper.hostnameVerifier())
//            }
            val client = okHttpBuilder.build()
            retrofit = builder.baseUrl(baseUrl).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
            cache[baseUrl] = retrofit
            return retrofit
        }

    }
}