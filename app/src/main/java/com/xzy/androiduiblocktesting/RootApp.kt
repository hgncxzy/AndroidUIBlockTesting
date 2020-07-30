package com.xzy.androiduiblocktesting

import android.app.Application
import com.xzy.androiduiblocktesting.choreographer.BlockDetectByChoreographer
import com.xzy.androiduiblocktesting.loop.BlockDetectByPrinter

/**
 * @author ：created by xzy.
 * @date ：2020/7/30
 */
internal class RootApp : Application() {
    override fun onCreate() {
        super.onCreate()
         BlockDetectByPrinter.start()
        //BlockDetectByChoreographer.start()
    }
}