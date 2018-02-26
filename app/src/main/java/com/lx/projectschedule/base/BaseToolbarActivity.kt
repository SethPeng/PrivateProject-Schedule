package com.lx.projectschedule.base

import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.lx.projectschedule.R
import com.yyxk.architectureframework.base.BaseActivity
import kotlinx.android.synthetic.main.base_activity_toolbar.*
import kotlinx.android.synthetic.main.base_activity_toolbar.view.*

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
 * 包名:com.lx.projectschedule.base
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/26 下午3:32
 * 修改人：LX
 * 修改时间：2018/2/26 下午3:32
 * 修改备注：
 */
abstract class BaseToolbarActivity : BaseActivity() {

    override fun beforeInit() {
        var contentView = LayoutInflater.from(this).inflate(setLayoutId(), null)
        var rootView = LayoutInflater.from(this).inflate(R.layout.base_activity_toolbar, null)
        rootView.root.addView(contentView)//在Toolbar下面添加View
        rootView.title.text = pageName//在Toolbar中设置Text标题
        rootView.tool_bar.title = ""
        setSupportActionBar(rootView.tool_bar)
        if (enableBackBtn()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        rootView.tool_bar.menu
        setContentView(rootView)
    }

    /**
     * 加载Toolbar
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return true
    }

    /**
     * 监听返回键点击
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 是否允许回退按钮
     */
    abstract fun enableBackBtn(): Boolean

    /**
     * 显示Toolbar菜单上的MenuItem
     */
    fun showMenuItem(@IdRes id:Int){
        tool_bar.menu.findItem(id).isVisible = true

    }

    /**
     * 隐藏Toolbar菜单上的MenuItem
     */
    fun hideMenuItem(@IdRes id:Int){
        tool_bar.menu.findItem(id).isVisible = false
    }

}