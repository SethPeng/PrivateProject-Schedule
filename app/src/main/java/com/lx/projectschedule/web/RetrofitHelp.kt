package com.lx.projectschedule.web

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：ProjectSchedule
 * 包名:com.lx.projectschedule.web
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/24 下午3:01
 * 修改人：LX
 * 修改时间：2018/2/24 下午3:01
 * 修改备注：
 */
class RetrofitHelp {
    private constructor()

    companion object {
        private val BASE_URL: String = "http://nbnewinterface.huerkang.com/"
        private lateinit var mRetrofit: Retrofit
        //单例
        var mInstance: RetrofitHelp? = null
            get() {
                if (field == null) field = RetrofitHelp()
                return field
            }
        //单例模式创建ResponseCallBack
        var mResponseCallBack: ResponseCallBack? = null
            get() {
                if (field == null) {
                    mRetrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(JsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build()
                    field = mRetrofit.create(ResponseCallBack::class.java)
                }
                return field
            }

        /**
         * 定制OkHttpClient
         */
        fun getOkHttpClient(): OkHttpClient {
            var client = OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true).build()

            return client
        }

        fun <T> toSubscribe(o: Observable<T>, s: Subscriber<T>) {
            o.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s)
        }
    }


}