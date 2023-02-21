package com.zat.finance.utils

import android.os.SystemClock
import android.view.View

abstract class OnSingleClickListener : View.OnClickListener {
    /**
     * 最短click事件的时间间隔
     */
    private val MIN_CLICK_INTERVAL: Long = 600

    /**
     * 上次click的时间
     */
    private var mLastClickTime: Long = 0

    /**
     * click响应函数
     * @param v The view that was clicked.
     */
    abstract fun onSingleClick(v: View?)

    override fun onClick(v: View?) {
        val currentClickTime: Long = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        //有可能2次连击，也有可能3连击，保证mLastClickTime记录的总是上次click的时间
        mLastClickTime = currentClickTime
        if (elapsedTime <= MIN_CLICK_INTERVAL) return
        onSingleClick(v)

    }
}