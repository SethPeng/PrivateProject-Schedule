package com.lx.labelviewtest.tabbar

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import com.lx.projectschedule.widgets.tabbar.Tab

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
 * 创建时间：2018/3/9 上午10:50
 * 修改人：LX
 * 修改时间：2018/3/9 上午10:50
 * 修改备注：
 */
class BottomTabBar : LinearLayout {


    private val mTabList = ArrayList<Tab>()
    private var mSelectedPosition: Int = 0
    private var mBindedViewPager: ViewPager? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setOrientation(orientation: Int) {
        super.setOrientation(HORIZONTAL)
        Log.i("Tag", "the bottom tab bar can't set custom orientation,the orientation always be HORIZONTAL")
    }

    /**
     * 添加一个Tab
     */
    private fun addTab(tab: Tab?) {
        if (tab == null) throw NullPointerException()
        if (tab.position > mTabList.size) throw IllegalArgumentException("tab index out of bound")
        val position = if (tab.position < 0) {
            mTabList.add(tab)
            mTabList.size-1
        } else {
            mTabList.add(tab.position, tab)
            tab.position
        }

        
        val imageView = ImageView(context)
        val params = LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
        imageView.layoutParams = params
        imageView.setImageResource(tab.viewUnSelect)
        imageView.setOnClickListener { setSelect(position)} //选择位置}
        addView(imageView, params)
    }

    /**
     * 清空所有Tab
     */
    private fun clearTab() {
        removeAllViews()
    }

    /**
     * 获取Tab
     */
    fun getTab(position: Int): Tab {
        return mTabList[position]
    }

    /**
     * 绑定ViewPager
     */
    fun bindViewPager(viewPager: ViewPager) {
        if (viewPager.adapter==null) throw NullPointerException("should use viewpager.setAdapter() before use bindViewPager()")
        mBindedViewPager = viewPager
        clearTab()//清空所有Tab
        //为LinearLayout添加每个Tab
        (0 until viewPager.adapter!!.count).forEach { addTab(Tab()) }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                setImageSelectDrawable(position)
            }
        })
    }

    /**
     * 设置选择图片的样式
     */
    private fun setImageSelectDrawable(position: Int) {
        val image = getChildAt(position) as ImageView
        val imageSelectedBefore = getChildAt(mSelectedPosition) as ImageView
        imageSelectedBefore.setImageResource(mTabList[mSelectedPosition].viewUnSelect)
        image.setImageResource(mTabList[position].viewSelect)
        mSelectedPosition = position
    }

    fun setSelect(position: Int) {
        mBindedViewPager?.currentItem = position
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        allInit()//初始化所有ImageView
        orientation = HORIZONTAL
    }

    /**
     * 初始化所有ImageView的图片显示
     */
    private fun allInit() {
        (0 until childCount).forEach {
            var image = getChildAt(it) as ImageView
            if (it == 0) {
                image.setImageResource(mTabList[it].viewSelect)
            } else {
                image.setImageResource(mTabList[it].viewUnSelect)
            }
        }

    }

}