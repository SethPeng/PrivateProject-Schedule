package com.yyxk.signdrawer

import android.content.Context
import android.graphics.*
import android.support.annotation.ColorInt
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lx.projectschedule.widgets.sign.PathSegment


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
 * 项目名称：TheSignDrawer
 * 包名:com.yyxk.signdrawer
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/24 上午10:00
 * 修改人：LX
 * 修改时间：2018/2/24 上午10:00
 * 修改备注：
 */
class SignView : View {
    private lateinit var mSignPaint: Paint
    var mSignColor = Color.BLACK//默认黑色
    var mSignWidth: Float = 10f//默认粗细10像素
    private var mTouchDownX = 0f//第一次点触X
    private var mTouchDownY = 0f//第一次点触Y
    private var mPaintMinWidth = 3f
    private var mPath: Path = Path()
    private var mBitmap: Bitmap? = null
    private var mCanvas: Canvas = Canvas()
    private val mPathSegments = ArrayList<PathSegment>()

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initView()
    }

    /**
     * 初始化
     */
    private fun initView() {
        mSignPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mSignPaint.color = mSignColor
        mSignPaint.strokeWidth = mSignWidth
        mSignPaint.style = Paint.Style.STROKE

    }

    /**
     * 创建双缓冲
     */
    private fun initBuffer() {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mCanvas.setBitmap(mBitmap)
    }


    override fun onDraw(canvas: Canvas) {
        if (mBitmap != null) canvas.drawBitmap(mBitmap, 0f, 0f, null)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mTouchDownX = event.x
                mTouchDownY = event.y
                mStartLength = 0f
                mPath = Path()
                mPathSegments.clear()
                mCanvas.save()
                mPath.moveTo(mTouchDownX, mTouchDownY)
                if (mBitmap == null) initBuffer()
            }
            MotionEvent.ACTION_MOVE -> {
                mPath.quadTo(mTouchDownX, mTouchDownY, (mTouchDownX + event.x) / 2, (mTouchDownY + event.y) / 2)
                speedControl(event)//追踪画笔速度，调整粗细
                mPathSegments.forEach {
                    mSignPaint.alpha = it.alpha
                    mSignPaint.strokeWidth = it.width
                    mCanvas.drawPath(it.path, mSignPaint)
                }
                invalidate()
                mTouchDownX = event.x
                mTouchDownY = event.y
            }
        }
        return true
    }

    private var mStartLength = 0f

    /**
     * 追踪画笔速度以调整粗细
     */
    private fun speedControl(event: MotionEvent): Boolean {
        var dx = Math.abs(event.x - mTouchDownX)
        var dy = Math.abs(event.y - mTouchDownY)
        var width = mSignWidth
        width -= dx / mSignWidth
        width -= dy / mSignWidth
        if (width < mPaintMinWidth) width = mPaintMinWidth
        cutPath(mPath, mStartLength, width)
        return false
    }

    /**
     * 将Path存入PathSegments
     */
    private fun cutPath(path: Path, startLength: Float, width: Float) {
        var pm = PathMeasure(path, false)
        var length = pm.length
        var desPath = Path()
        pm.getSegment(startLength, length, desPath, true)
        var pe = PathSegment()
        pe.path = desPath
        pe.width = width
        pe.alpha = (255*width/mSignWidth).toInt()
        mPathSegments.add(pe)
        mStartLength = length
    }

    /**
     * 检查是否有下一轮廓
     */
    private fun checkNext(pm: PathMeasure): PathMeasure {
        var hasNext = pm.nextContour()
        if (hasNext) {
            return checkNext(pm)
        } else {
            return pm
        }

    }

    /**
     * 清空
     */
    fun clear() {
        mPath.reset()
        mPathSegments.clear()
        mBitmap?.recycle()
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mCanvas.setBitmap(mBitmap)
        invalidate()
    }

    /**
     * 切换颜色
     */
    fun changeColor(@ColorInt color: Int) {
        mSignPaint.color = color
        invalidate()
    }

    /**
     * 获取最终签名Bitmap
     */
    fun getPicture(): Bitmap? {
        isDrawingCacheEnabled = true
        val bm = drawingCache
        val result = Bitmap.createBitmap(bm)
        destroyDrawingCache()
        return result
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mBitmap?.recycle()
    }
}