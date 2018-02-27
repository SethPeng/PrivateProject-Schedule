package com.lx.projectschedule.web.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.lx.projectschedule.R
import com.lx.projectschedule.util.FontDisplayUtil
import kotlinx.android.synthetic.main.progress_dialog.view.*

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
 * 包名:com.lx.projectschedule.web.dialog
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/27 下午1:36
 * 修改人：LX
 * 修改时间：2018/2/27 下午1:36
 * 修改备注：
 */
class ProgressDialog {

    companion object {

        private lateinit var mAlertDialog: AlertDialog
        /**
         * 显式dialog
         */
        fun showDialog(context: Context) {
            var view = LayoutInflater.from(context).inflate(R.layout.progress_dialog, null)
            Glide.with(context).asGif().load(R.drawable.loading).into(view.loading_image)
            var builder = AlertDialog.Builder(context)
            builder.setView(view).setCancelable(false)
            mAlertDialog = builder.create()
            mAlertDialog.show()
            mAlertDialog.window.setLayout(FontDisplayUtil.dip2px(130f), FontDisplayUtil.dip2px(130f))
        }

        /**
         * 隐藏Dialog
         */
        fun hideDialog() {
            mAlertDialog.hide()
        }
    }

}