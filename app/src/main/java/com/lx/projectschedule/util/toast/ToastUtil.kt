package com.lx.projectschedule.util.toast

import com.lx.projectschedule.R
import com.lx.projectschedule.util.log.LogUtil
import com.yyxk.x_toast.XToast
import com.yyxk.x_toast.XToastConfig

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
 * 包名:com.lx.projectschedule.util.toast
 * 类描述：Toast工具类
 * 创建人：LX
 * 创建时间：2018/2/24 下午2:21
 * 修改人：LX
 * 修改时间：2018/2/24 下午2:21
 * 修改备注：
 */
class ToastUtil {
    companion object {
        fun showText(text: String) {
            XToast.showText(text,XToastConfig().setDefaultLayout(R.layout.default_toast_ui)
                    .setDirection(XToastConfig.DIRECTION.BOTTOM)
                    .setMarginVertical(50)
                    .setBufferSize(5)
                    .setAnimation(com.yyxk.x_toast.R.style.DefaultToastAnimation)
                    .setTimeLong(1500))
            LogUtil.v("showToast:{$text}")
        }
    }

}