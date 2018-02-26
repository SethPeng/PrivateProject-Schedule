package com.lx.projectschedule.web

import com.lx.projectschedule.bean.BaseBean
import com.lx.projectschedule.bean.TestBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

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
 * 创建时间：2018/2/24 下午3:00
 * 修改人：LX
 * 修改时间：2018/2/24 下午3:00
 * 修改备注：
 */
interface ResponseCallBack {

    @FormUrlEncoded
    @POST("{path}")
    fun test(@Path("path") path: String,@Field("id")id:String): Observable<BaseBean<TestBean>>

}