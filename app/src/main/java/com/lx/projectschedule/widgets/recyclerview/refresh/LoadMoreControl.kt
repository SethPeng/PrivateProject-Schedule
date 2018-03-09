package com.lx.xrecyclerview.refresh

import android.animation.ValueAnimator
import android.view.View
import android.widget.LinearLayout

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
 * 项目名称：XRecyclerTest
 * 包名:com.lx.xrecyclerview.refresh
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/3/8 下午2:14
 * 修改人：LX
 * 修改时间：2018/3/8 下午2:14
 * 修改备注：
 */
class LoadMoreControl(private var mHeight: Int, private var mPercentToRefresh: Float) : BaseControl() {
    override fun onActionUp(view: View, onRefreshListenerList: ArrayList<OnRefreshListener>) {
        var params = view.layoutParams as LinearLayout.LayoutParams
        if (isOnPosition(params)) {
            onRefreshListenerList.forEach {
                isRefreshing=true
                it.onLoadMore()
            }
        } else {
            animationMoveBack(view)
        }
    }

    override fun animationMoveBack(view: View) {
        var params = view.layoutParams as LinearLayout.LayoutParams
        animationBack(params.bottomMargin, mHeight, { value ->
            params.bottomMargin = value
            view.layoutParams = params
        })
    }


    override fun onMove(originY: Float, nowY: Float, view: View): Int {
        var params = view.layoutParams as LinearLayout.LayoutParams
        var margin = (mHeight + (originY - nowY) * 0.8).toInt()
        if (margin > 0) margin = 0
        params.bottomMargin = margin
        view.layoutParams = params
        return margin
    }

    override fun isOnPosition(params: LinearLayout.LayoutParams) = params.bottomMargin > mHeight * mPercentToRefresh


    fun moveLoadMoreViewTo(dy:Int,view: View){
        if (dy < 0) throw IllegalArgumentException("dy can't be smaller then 0")
        var params = view.layoutParams as LinearLayout.LayoutParams
        var anim = ValueAnimator.ofInt(params.bottomMargin, mHeight + dy)
        anim.duration = 300
        anim.addUpdateListener {
            params.bottomMargin = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.start()
    }
}