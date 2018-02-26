package com.lx.projectschedule.ui

import android.os.Bundle
import com.lx.projectschedule.R
import com.lx.projectschedule.viewmodel.MainViewModel
import com.yyxk.architectureframework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
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
        }
    }



    interface Contract{
        fun onTextClickListener()
    }
}
