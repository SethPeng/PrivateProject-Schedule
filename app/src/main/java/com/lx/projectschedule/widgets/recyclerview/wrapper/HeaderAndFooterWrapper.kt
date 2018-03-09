package com.lx.xrecyclerview.wrapper

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

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
 * 创建时间：2018/3/5 上午9:15
 * 修改人：LX
 * 修改时间：2018/3/5 上午9:15
 * 修改备注：
 */
class HeaderAndFooterWrapper<VH: RecyclerView.ViewHolder>(private val mInnerAdapter:RecyclerView.Adapter<VH>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    private val mHeaderViews: SparseArrayCompat<View> = SparseArrayCompat()
    private val mFooterViews: SparseArrayCompat<View> = SparseArrayCompat()

    private val HEADER_TYPE: Int = 10000
    private val FOOTER_TYPE: Int = 20000


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):  RecyclerView.ViewHolder {
        return when {
            mHeaderViews.get(viewType)!=null -> {
                ViewHolderFactory.createViewHolder(parent!!, mHeaderViews.get(viewType))
            }
            mFooterViews.get(viewType)!=null -> {
                ViewHolderFactory.createViewHolder(parent!!, mFooterViews.get(viewType))
            }
            else -> {
                mInnerAdapter.onCreateViewHolder(parent,viewType)
            }
        }
    }

    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position: Int) {
        when{
            isHeaderPosition(position)->return
            isFooterPosition(position)->return
            else->{
                mInnerAdapter.onBindViewHolder(holder as VH,position)
            }
        }
    }

    override fun getItemCount(): Int {
        return mInnerAdapter.itemCount+mHeaderViews.size()+mFooterViews.size()
    }


    override fun getItemViewType(position: Int): Int {
        if (isHeaderPosition(position)) {
            return mHeaderViews.keyAt(position)
        }else if(isFooterPosition(position)){
            return mFooterViews.keyAt(position-mHeaderViews.size()-mInnerAdapter.itemCount)
        }
        return mInnerAdapter.getItemViewType(position-mHeaderViews.size())
    }

    /**
     * 判断是否是Header的Position
     */
    private fun isHeaderPosition(position: Int): Boolean {
        return position < mHeaderViews.size()
    }

    /**
     * 判断是否是Footer的Position
     */
    private fun isFooterPosition(position: Int): Boolean {
        return position >= mHeaderViews.size()+mInnerAdapter.itemCount
    }

    /**
     * 添加Header
     */
    fun addHeader(header:View){
        mHeaderViews.put(mHeaderViews.size()+HEADER_TYPE,header)
    }

    /**
     * 添加Footer
     */
    fun addFooter(footer: View){
        mFooterViews.put(mFooterViews.size()+FOOTER_TYPE,footer)
    }

    class ViewHolderFactory{
        companion object {
            fun createViewHolder(parent: ViewGroup,view:View):RecyclerView.ViewHolder{
                return object :RecyclerView.ViewHolder(view){
                }
            }
        }
    }
}