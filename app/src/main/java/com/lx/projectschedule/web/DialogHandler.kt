package com.lx.projectschedule.web

/**
 * Created by Random on 2018/2/26.
 */
class DialogHandler private constructor() {

    companion object {
        var mInstances:DialogHandler?=null
            get() {
                if(field==null)
                    field= DialogHandler()
                return field
            }
    }

    var mRequestCount=0//请求次数

    fun begin(){
        mRequestCount++
    }

    fun end(){
        mRequestCount--
    }
}