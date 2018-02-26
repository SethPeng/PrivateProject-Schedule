package com.lx.projectschedule.ui

import android.content.Intent
import android.os.Bundle
import com.lx.projectschedule.R
import com.yyxk.architectureframework.base.BaseActivity

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
 * 包名:com.lx.projectschedule.ui
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/26 下午3:30
 * 修改人：LX
 * 修改时间：2018/2/26 下午3:30
 * 修改备注：
 */
class WelcomeActivity:BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun setPageName(): String {
        return "欢迎"
    }

    override fun init(savedInstanceState: Bundle?){
//        var intent= Intent(this,MainActivity::class.java)
//        startActivity(intent)
    }

}