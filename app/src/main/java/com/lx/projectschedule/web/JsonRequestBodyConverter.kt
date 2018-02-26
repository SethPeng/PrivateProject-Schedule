package com.lx.projectschedule.web

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter

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
 * 创建时间：2018/2/26 上午9:32
 * 修改人：LX
 * 修改时间：2018/2/26 上午9:32
 * 修改备注：
 */
class JsonRequestBodyConverter<T>(private var gson: Gson, private var adapter: TypeAdapter<T>) :Converter<T,RequestBody> {


    companion object {
        private val MEDIA_TYPE=MediaType.parse("application/json; charset=UTF-8")

    }


    override fun convert(value: T): RequestBody {

        var postBody=gson.toJson(value.toString())
        return RequestBody.create(MEDIA_TYPE,postBody)
    }


}