package com.lx.projectschedule.util.log

import com.yyxk.xlog.LogListener
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
 * 包名:com.lx.projectschedule.util.log
 * 类描述：Log工具类
 * 创建人：LX
 * 创建时间：2018/2/24 下午2:08
 * 修改人：LX
 * 修改时间：2018/2/24 下午2:08
 * 修改备注：
 */
class LogUtil : LogListener {

    /**
     * 打印日志监听捕获
     */
    override fun whenLogPrint(type: Int, tag: String?, msg: String?, header: String?) {

    }

    companion object {


        fun i(tag: String, objMsg: Any) {
            XLog.i(tag,objMsg)
        }

        fun i(objMsg: Any) {
            XLog.i(objMsg)
        }

        fun d(tag: String, objMsg: Any) {
            XLog.d(tag,objMsg)
        }

        fun d(objMsg: Any) {
            XLog.d(objMsg)
        }

        fun e(tag: String, objMsg: Any) {
            XLog.e(tag,objMsg)
        }

        fun e(objMsg: Any) {
            XLog.e(objMsg)
        }

        fun v(tag: String, objMsg: Any) {
            XLog.v(tag,objMsg)
        }

        fun v(objMsg: Any) {
            XLog.v(objMsg)
        }

        fun w(tag: String, objMsg: Any) {
            XLog.w(tag,objMsg)
        }

        fun w(objMsg: Any) {
            XLog.w(objMsg)
        }

        fun wtf(tag: String, objMsg: Any) {
            XLog.wtf(tag,objMsg)
        }

        fun wtf( objMsg: Any) {
            XLog.wtf(objMsg)
        }
    }

}