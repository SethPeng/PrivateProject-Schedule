package com.lx.projectschedule.web

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lx.projectschedule.util.log.LogUtil
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

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
 * 创建时间：2018/2/26 上午9:25
 * 修改人：LX
 * 修改时间：2018/2/26 上午9:25
 * 修改备注：
 */
class JsonConverterFactory private constructor(var gson: Gson) : Converter.Factory() {

    companion object {
        fun create():JsonConverterFactory{
            return create(Gson())
        }

        fun create(gson: Gson):JsonConverterFactory{
            return JsonConverterFactory(gson)
        }
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *> {
        LogUtil.w("======响应======")
        var adapter=gson.getAdapter(TypeToken.get(type))
        return JsonResponseBodyConverter(gson,adapter)
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody> {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

}