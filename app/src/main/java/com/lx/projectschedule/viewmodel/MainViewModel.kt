package com.lx.projectschedule.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import com.lx.projectschedule.bean.TestBean
import com.lx.projectschedule.ui.MainActivity
import com.lx.projectschedule.util.log.LogUtil
import com.lx.projectschedule.util.toast.ToastUtil
import com.lx.projectschedule.web.RetrofitHelp
import com.lx.projectschedule.web.WebUtil
import com.yyxk.architectureframework.base.BaseViewModel
import com.yyxk.architectureframework.center.data.OnDataReceive

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
 * 包名:com.lx.projectschedule.viewmodel
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/24 下午5:30
 * 修改人：LX
 * 修改时间：2018/2/24 下午5:30
 * 修改备注：
 */
class MainViewModel:BaseViewModel(), MainActivity.Contract {
    companion object {
        const val FIRST_TEST:String="FIRST_TEST"
    }

    override fun onViewStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {

    }

    override fun onTextClickListener() {
        var callback=RetrofitHelp.mResponseCallBack!!.test("login.json","2")
        WebUtil.request(FIRST_TEST,getBandedView(MainActivity::class.java).activityContext,this,callback)
        ToastUtil.showText("alala")
    }


    @OnDataReceive(Event = FIRST_TEST)
    fun onNetWorkSuccess(bean:TestBean){
        LogUtil.i(bean.toString())
    }



}