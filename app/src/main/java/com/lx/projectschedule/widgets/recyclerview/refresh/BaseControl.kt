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
 * 创建时间：2018/3/8 下午2:15
 * 修改人：LX
 * 修改时间：2018/3/8 下午2:15
 * 修改备注：
 */
abstract class BaseControl {

    var isRefreshing:Boolean=false

    abstract fun isOnPosition(params: LinearLayout.LayoutParams):Boolean

    //以动画形式收起刷新
    abstract fun animationMoveBack(view: View)

    abstract fun onMove(originY:Float, nowY:Float, view: View ):Int

    abstract fun onActionUp(view:View,onRefreshListenerList: ArrayList<OnRefreshListener>)

    fun animationBack(nowY:Int,height:Int,onAnimationBack: (Int)->Unit){
        var anim = ValueAnimator.ofInt(nowY, height)
        anim.addUpdateListener {
            onAnimationBack(it.animatedValue as Int)
        }
        anim.duration = 400
        anim.start()
    }

    open fun finishRefresh(view: View){
        if(isRefreshing){
            animationMoveBack(view)
        }
        isRefreshing=false
    }

}