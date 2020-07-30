package com.xzy.androiduiblocktesting.loop

import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log

/**
 * @author ：created by xzy.
 * @date ：2020/7/30
 */
class LogMonitor private constructor() {
    private val mLogThread = HandlerThread("log")
    private val mIoHandler: Handler
    val isMonitor: Boolean
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            mIoHandler.hasCallbacks(mLogRunnable)
        } else false

    fun startMonitor() {
        mIoHandler.postDelayed(mLogRunnable, TIME_BLOCK)
    }

    fun removeMonitor() {
        mIoHandler.removeCallbacks(mLogRunnable)
    }

    companion object {
        val instance = LogMonitor()
        private const val TIME_BLOCK = 1000L
        private val mLogRunnable = Runnable {
            val sb = StringBuilder()
            val stackTrace =
                Looper.getMainLooper().thread.stackTrace
            for (s in stackTrace) {
                sb.append(
                    """
    $s

    """.trimIndent()
                )
            }
            Log.e("TAG", sb.toString())
        }

    }

    init {
        mLogThread.start()
        mIoHandler = Handler(mLogThread.looper)
    }
}