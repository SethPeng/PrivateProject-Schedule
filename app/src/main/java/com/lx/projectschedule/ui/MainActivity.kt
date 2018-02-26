package com.lx.projectschedule.ui

import android.os.Bundle
import android.view.Menu
import com.lx.projectschedule.R
import com.lx.projectschedule.base.BaseToolbarActivity
import com.lx.projectschedule.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseToolbarActivity() {

    private var showSearch:Boolean=true

    override fun enableBackBtn(): Boolean {
        return true
    }

    private lateinit var mViewModel:Contract
    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setPageName(): String {
        return "主页面"
    }

    override fun init(savedInstanceState: Bundle?) {
        mViewModel=getViewModel(MainViewModel::class.java)
        text_view.setOnClickListener {
            mViewModel.onTextClickListener()
            hideMenuItem(R.id.search_btn)
        }
    }



    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        when(showSearch){
            true->{
                showMenuItem(R.id.search_btn)
            }
            false->{
                hideMenuItem(R.id.search_btn)
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    interface Contract{
        fun onTextClickListener()
    }
}
