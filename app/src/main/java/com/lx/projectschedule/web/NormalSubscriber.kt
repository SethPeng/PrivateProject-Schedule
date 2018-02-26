package com.lx.projectschedule.web

import android.content.Context
import com.lx.projectschedule.util.log.LogUtil
import com.lx.projectschedule.util.toast.ToastUtil
import retrofit2.adapter.rxjava.HttpException
import rx.Subscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

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
 * 创建时间：2018/2/24 下午4:10
 * 修改人：LX
 * 修改时间：2018/2/24 下午4:10
 * 修改备注：
 */
class NormalSubscriber<T>(private var context:Context, private var onNextListener: SubscriberOnNextListener<T>, private val onErrorListener: SubscriberOnErrorListener):Subscriber<T>() {

    override fun onStart() {
        super.onStart()
        showDialog()
    }

    override fun onCompleted() {
        dismissDialog()
    }

    override fun onError(e: Throwable) {
        //公共网络错误处理
        when (e) {
            is SocketTimeoutException -> ToastUtil.showText("链接失败（SocketTimeoutException）")
            is ConnectException -> ToastUtil.showText("网络中断，请检查您的网络状态")
            is TimeoutException -> ToastUtil.showText("链接失败（连接超时）")
            is HttpException -> ToastUtil.showText("无法连接到服务器")
            is UnknownHostException -> ToastUtil.showText("网络异常（UnknownHostException）")
            else -> {
                LogUtil.e( "errorCause:${e.cause}")
                LogUtil.e( "errorMsg:${e.message}")
                e.printStackTrace()
                //其他异常处理交由onError()处理
                onErrorListener.onError(e)
            }
        }
    }

    override fun onNext(t: T) {
        onNextListener.onNext(t)
    }


    /**
     * 显示Dialog
     */
    private fun showDialog() {

    }

    /**
     * 隐藏Dialog
     */
    private fun dismissDialog() {

    }

}