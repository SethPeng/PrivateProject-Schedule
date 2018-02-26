package com.lx.projectschedule.web

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.lx.projectschedule.util.log.LogUtil
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException

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
 * 创建时间：2018/2/26 上午9:52
 * 修改人：LX
 * 修改时间：2018/2/26 上午9:52
 * 修改备注：
 */
class JsonResponseBodyConverter<T>:Converter<ResponseBody,T> {

    private val mGson: Gson//gson对象
    private val adapter: TypeAdapter<T>

    /**
     * 构造器
     */
    constructor(gson: Gson, adapter: TypeAdapter<T>) {
        this.mGson = gson
        this.adapter = adapter
    }

    /**
     * 转换
     *
     * @param responseBody
     * @return
     * @throws IOException
     */
    @Throws(IOException::class) override fun convert(responseBody: ResponseBody): T {
        val response = responseBody.string()
        LogUtil.w("服务器数据：" + response)
        try {
            return adapter.fromJson(response)
        } finally {
            responseBody.close()
        }

    }
}