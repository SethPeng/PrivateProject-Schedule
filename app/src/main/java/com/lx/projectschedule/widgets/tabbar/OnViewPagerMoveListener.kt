package com.lx.labelviewtest.tabbar

import android.widget.ImageView

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
 * 项目名称：LabelViewTest
 * 包名:com.lx.labelviewtest.tabbar
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/3/9 上午11:35
 * 修改人：LX
 * 修改时间：2018/3/9 上午11:35
 * 修改备注：
 */
interface OnViewPagerMoveListener {
    fun OnPageScroll(imageView: ImageView, position: Int, positionOffset: Float, positionOffsetPixels: Int )
}