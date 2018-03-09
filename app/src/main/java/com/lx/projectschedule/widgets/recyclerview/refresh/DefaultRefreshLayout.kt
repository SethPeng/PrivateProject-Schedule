package com.lx.xrecyclerview.refresh

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import com.lx.xrecyclerview.R

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
 * 创建时间：2018/3/6 下午3:26
 * 修改人：LX
 * 修改时间：2018/3/6 下午3:26
 * 修改备注：
 */
class DefaultRefreshLayout(context: Context?, attrs: AttributeSet?) : BaseRecyclerRefreshLayout(context, attrs),OnPullUpListener,OnRefreshListener,OnRefreshFinishListener {


    override fun onFinish() {
        mAnim?.cancel()
    }

    override fun onRefresh() {
        moveRefreshHeaderTo(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90f,context.resources.displayMetrics).toInt())
        startImageAnimation(mImageView.rotation)
    }

    override fun onLoadMore() {
    }

    var mBackgroundColor:Int=0xffffff
    private var mBaseRotation=0f
    private var mImageView: ImageView
    private var mAnim:ValueAnimator?=null

    override fun onRefreshPullUp(distance: Float) {
        mImageView.rotation=mBaseRotation+distance*500
    }

    override fun onLoadMorePullUp(distance: Float) {
    }

    /**
     * 开始自动滚动
     */
    private fun startImageAnimation(originRotation:Float) {
        mAnim= ValueAnimator.ofFloat(originRotation, originRotation+720)
        mAnim!!.duration=2000
        mAnim!!.interpolator=LinearInterpolator()
        mAnim!!.repeatMode=ValueAnimator.RESTART
        mAnim!!.repeatCount=ValueAnimator.INFINITE
        mAnim!!.addUpdateListener {
            Log.i("taggg","it=${it.animatedValue}")
            mImageView.rotation=it.animatedValue as Float
        }
        mAnim!!.start()
    }

    init{
        var refreshView= LayoutInflater.from(context).inflate(com.lx.xrecyclerview.R.layout.default_refresh_layout,null)
        mRefreshHeaderView=refreshView
        mRefreshLoadMoreView=LayoutInflater.from(context).inflate(com.lx.xrecyclerview.R.layout.default_refresh_layout,null)
        enableLoadMore=true
        var root=refreshView.findViewById<RelativeLayout>(R.id.root)
        root.setBackgroundColor(mBackgroundColor)
        mImageView=refreshView.findViewById(R.id.image)
        mBaseRotation=mImageView.rotation
        mOnPullUpListener=this
        addOnRefreshListener(this)
        mOnFinishListener=this
    }
}