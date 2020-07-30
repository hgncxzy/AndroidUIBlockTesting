package com.xzy.androiduiblocktesting.choreographer

import android.view.Choreographer
import android.view.Choreographer.FrameCallback
import com.xzy.androiduiblocktesting.loop.LogMonitor

/**
 * @author ：created by xzy.
 * @date ：2020/7/30
 */
object BlockDetectByChoreographer {
    private const val lastTime: Long = 0
    fun start() {
        Choreographer.getInstance()
            .postFrameCallback(object : FrameCallback {
                override fun doFrame(l: Long) {
                    if (LogMonitor.instance.isMonitor) {
                        LogMonitor.instance.removeMonitor()
                    }
                    LogMonitor.instance.startMonitor()
                    Choreographer.getInstance().postFrameCallback(this)
                }
            })
    }
}