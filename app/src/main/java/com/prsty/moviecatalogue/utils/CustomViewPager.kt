package com.prsty.moviecatalogue.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private var enable: Boolean = false

    init {
        this.enable = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.enable) super.onTouchEvent(event) else false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.enable) super.onInterceptTouchEvent(event) else false
    }

    fun setPagingEnabled(enabled: Boolean) {
        this.enable = enabled
    }
}