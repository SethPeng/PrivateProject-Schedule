package com.lx.xrecyclerview.refresh

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent
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
 * 包名:com.lx.xrecyclerview
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/3/5 上午10:02
 * 修改人：LX
 * 修改时间：2018/3/5 上午10:02
 * 修改备注：
 */
open class BaseRecyclerRefreshLayout : LinearLayout {
    private lateinit var mRecyclerView: RecyclerView
    private var isScrollToTop = true//是否移动到顶端
    private var isScrollToBottom = false//是否移动到底部
    private var mTouchDownX = 0f
    private var mTouchDownY = 0f
    private var mRefreshHeight = 0
    private var mLoadMoreHeight = 0
    private val mOnRefreshListenerList = ArrayList<OnRefreshListener>()
    private lateinit var mLoadmoreControl: LoadMoreControl
    private lateinit var mRefreshControl: RefreshControl
    var enableLoadMore = true   //是否允许上拉加载
    var mPercentToRefresh = 0.4f //下拉百分之多少，可以视为下拉刷新
        set(value) {
            if (value > 1 || value < 0) throw IllegalArgumentException("the mPercentToRefresh can't bigger then 1 or smaller then 0")
        }
    var mPercentToLoadMore = 0.4f//上拉加载百分比
        set(value) {
            if (value > 1 || value < 0) throw IllegalArgumentException("the mPrecentToLoadMore can't bigger then 1 or smaller then 0")
        }
    var mOnPullUpListener: OnPullUpListener? = null //下拉刷新程度或者上拉刷新程度监听器
    var mRefreshHeaderView: View? = null
        set(value) {
            addHeader(value)
            field = value
        }
    var mRefreshLoadMoreView: View? = null
        set(value) {
            addFooter(value)
            field = value
        }

    var mOnFinishListener: OnRefreshFinishListener? = null

    private constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        orientation = LinearLayout.VERTICAL
        childCount
        initView()
    }

    fun addOnRefreshListener(onRefreshListener: OnRefreshListener?) {
        if (onRefreshListener != null) mOnRefreshListenerList.add(onRefreshListener)
    }

    private fun initView() {
        if (!isOnlyOneRecyclerView()) {
            throw IllegalStateException("the RecyclerRefreshLayout can only have one child,and it must extends RecyclerView")
        }
        mLoadmoreControl = LoadMoreControl(mLoadMoreHeight, mPercentToLoadMore)
        mRefreshControl = RefreshControl(mRefreshHeight, mPercentToRefresh)
        bindRecyclerView()
        bindRecyclerViewScroll()
    }

    /**
     * 添加一个刷新
     */
    private fun addHeader(field: View?) {
        if (field == null) throw NullPointerException("the refresh header view is null")
        if (field.parent != null) throw IllegalStateException("the refresh header view is already have a parent")

        var params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        field.measure(0, 0)
        mRefreshHeight = -field.measuredHeight
        params.topMargin = mRefreshHeight
        field.layoutParams = params
        addView(field, 0)//添加刷新头，并且设置marginTop=-1
    }

    private fun addFooter(field: View?) {
        if (field == null) throw NullPointerException("the load more view is null")
        if (field.parent != null) throw IllegalStateException("the load more view is already have a parent")

        var params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        field.measure(0, 0)
        mLoadMoreHeight = -field.measuredHeight
        params.bottomMargin = mLoadMoreHeight
        field.layoutParams = params
        post({
            addView(field, -1)//添加上拉加载
        })
    }


    /**
     * 绑定RecyclerView
     */
    private fun bindRecyclerView() {
        mRecyclerView = getChildAt(1) as RecyclerView
        var params = mRecyclerView.layoutParams as LinearLayout.LayoutParams
        params.height = 0
        params.weight = 1f
        mRecyclerView.layoutParams = params
    }

    /**
     * 绑定RecyclerView的滚动事件
     */
    private fun bindRecyclerViewScroll() {
        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                isScrollToTop = !recyclerView!!.canScrollVertically(-1)
                isScrollToBottom = !recyclerView.canScrollVertically(1)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    /**
     * 判断是否只有一个RecyclerView
     */
    private fun isOnlyOneRecyclerView(): Boolean {
        val count = (0 until childCount).count { getChildAt(it) is RecyclerView }
        if (count == 1) {
            return true
        }
        return false
    }

    /**
     * 判断准备下啦刷新
     */
    private fun isReadyToPull(): Boolean {
        return isScrollToTop
    }

    /**
     * 判断是否准备上拉加载
     */
    private fun isReadyToLoadMore(): Boolean {
        return isScrollToBottom && enableLoadMore
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var paramsRefresh = getChildAt(0).layoutParams as LinearLayout.LayoutParams
        var paramsLoadMore = getChildAt(2).layoutParams as LinearLayout.LayoutParams
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                if (isReadyToPull()) {
                    var margin = mRefreshControl.onMove(mTouchDownY, event.y, getChildAt(0))
                    mOnPullUpListener?.onRefreshPullUp(Math.abs((margin - mRefreshHeight) / mRefreshHeight.toFloat()))
                } else {
                    val margin = mLoadmoreControl.onMove(mTouchDownY, event.y, getChildAt(2))
                    mRecyclerView.scrollToPosition(mRecyclerView.adapter.itemCount-1)
                    mOnPullUpListener?.onLoadMorePullUp(Math.abs((margin - mLoadMoreHeight) / mLoadMoreHeight.toFloat()))
                }

            }
            MotionEvent.ACTION_UP -> {
                if (isReadyToPull()) {
                    mRefreshControl.onActionUp(getChildAt(0), mOnRefreshListenerList)
                } else {
                    mLoadmoreControl.onActionUp(getChildAt(2), mOnRefreshListenerList)
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                mTouchDownX = ev.x
                mTouchDownY = ev.y
            }
            MotionEvent.ACTION_MOVE -> {
                if (isMoveToUp(ev.y) && isReadyToPull()) {
                    return true
                } else if (isMoveToDown(ev.y) && isReadyToLoadMore()) {
                    return true
                }
            }
            MotionEvent.ACTION_UP -> {
                mTouchDownY = 0f
                mTouchDownX = 0f
                return true
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    /**
     * 判断是否向上移动
     */
    private fun isMoveToUp(y: Float): Boolean {
        return y > mTouchDownY
    }

    private fun isMoveToDown(y: Float): Boolean {
        return y < mTouchDownY
    }


    /**
     * 结束刷新
     */
    fun finishRefresh() {
        mRefreshControl.finishRefresh(getChildAt(0))
        mLoadmoreControl.finishRefresh(getChildAt(2))
        mOnFinishListener?.onFinish()
    }

    /**
     * 以动画形式移动刷新头部到一定位置
     * 正常状态dy=0
     */
    fun moveRefreshHeaderTo(dy: Int) {
        mRefreshControl.moveHeaderTo(dy, getChildAt(0))
    }

    /**
     * 以动画形式移动
     */
    fun moveLoadMoreViewTo(dy: Int) {
        mLoadmoreControl.moveLoadMoreViewTo(dy, getChildAt(2))
    }

}