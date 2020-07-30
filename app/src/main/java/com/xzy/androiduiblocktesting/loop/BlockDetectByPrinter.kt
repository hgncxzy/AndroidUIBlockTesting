package com.xzy.androiduiblocktesting.loop

import android.os.Looper
import android.util.Printer

/**
 * @author ：created by xzy.
 * @date ：2020/7/30
 */
object BlockDetectByPrinter {
    @JvmStatic
    fun start() {
        Looper.getMainLooper().setMessageLogging(object : Printer {
            private val START = ">>>>> Dispatching"
            private val END = "<<<<< Finished"
            override fun println(x: String) {
                if (x.startsWith(START)) {
                    LogMonitor.instance.startMonitor()
                }
                if (x.startsWith(END)) {
                    LogMonitor.instance.removeMonitor()
                }
            }
        })
    }
}