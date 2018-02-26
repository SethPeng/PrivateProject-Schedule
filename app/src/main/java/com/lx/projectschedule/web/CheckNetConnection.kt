package com.lx.projectschedule.web

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.lx.projectschedule.MainApplication

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
 * 类描述：检查网络连接是否存在
 * 创建人：LX
 * 创建时间：2018/2/24 下午2:44
 * 修改人：LX
 * 修改时间：2018/2/24 下午2:44
 * 修改备注：
 */
class CheckNetConnection {

    companion object {
        private var mManager: ConnectivityManager? = null
        /**
         * 判断网络是否有连接
         */
        fun isNetAvailable():Boolean {
            if (mManager == null) mManager = MainApplication.mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var info=mManager!!.allNetworkInfo
            if(info!=null){
                (0..info.size).filter { info[it].state==NetworkInfo.State.CONNECTED }.forEach { return true }
            }
            return false
        }
    }
}