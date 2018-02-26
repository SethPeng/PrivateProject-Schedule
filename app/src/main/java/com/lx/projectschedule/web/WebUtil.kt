package com.lx.projectschedule.web

import android.content.Context
import com.lx.projectschedule.bean.BaseBean
import com.yyxk.architectureframework.base.BaseViewModel
import com.yyxk.architectureframework.center.data.DataCenter
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
 * 创建时间：2018/2/24 下午3:23
 * 修改人：LX
 * 修改时间：2018/2/24 下午3:23
 * 修改备注：
 */
class WebUtil {
    companion object {
        /**
         * 请求数据
         */
        fun <T> request(event:String,context: Context,viewModel: BaseViewModel, observable: Observable<BaseBean<T>>) {
            var observable=observable.map(HttpResultFunc<T>())
            RetrofitHelp.toSubscribe(observable,NormalSubscriber(context,object:SubscriberOnNextListener<T>{
                override fun onNext(t: T) {
                    DataCenter.getInstance().changeData(viewModel,event,t)
                }
            },object :SubscriberOnErrorListener{
                override fun onError(e: Throwable) {
                    DataCenter.getInstance().changeData(viewModel,event,null)
                }
            }))
        }
    }

}
