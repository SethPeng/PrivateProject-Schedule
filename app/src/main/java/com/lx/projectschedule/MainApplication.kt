package com.lx.projectschedule

import android.app.Application
import android.content.Context
import com.lx.projectschedule.util.log.LogUtil
import com.yyxk.x_toast.XToast
import com.yyxk.xlog.XLog

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
 * 包名:com.lx.projectschedule
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/24 下午2:06
 * 修改人：LX
 * 修改时间：2018/2/24 下午2:06
 * 修改备注：
 */


class MainApplication:Application(){

    companion object {
        val DEFAULT_TAG="taggg"
        lateinit var mContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        mContext=this
        //初始化XToast
        XToast.init(this)
        //初始化XLog，监听日志记录
        XLog.init(true, DEFAULT_TAG,LogUtil())
    }



}