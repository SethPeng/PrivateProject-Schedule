package com.lx.projectschedule.web.dialog

import android.content.Context

/**
 * Created by Random on 2018/2/26.
 */
object DialogHandler {

    private var mRequestCount = 0//请求次数

    /**
     * 请求显示Dialog
     */
    fun requestShowDialog(context: Context) {
        synchronized(DialogHandler::class.java) {
            when (mRequestCount) {
                0 -> {
                    mRequestCount++
                    ProgressDialog.showDialog(context)
                }
                else -> {
                    mRequestCount++
                }
            }
        }
    }

    /**
     * 请求隐藏Dialog
     */
    fun requestHideDialog() {
        synchronized(DialogHandler::class.java) {
            when (mRequestCount) {
                1 -> {
                    mRequestCount--
                    ProgressDialog.hideDialog()
                }
                0 -> {
                    throw IllegalStateException("are there any dialog?")
                }
                else -> {
                    mRequestCount--

                }
            }
        }
    }
}