package com.xzy.androiduiblocktesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xzy.androiduiblocktesting.databinding.ActivityMainBinding

/**
 * Android UI性能优化 检测应用中的UI卡顿
 * https://blog.csdn.net/lmj623565791/article/details/58626355
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.apply {
            btnTest1.setOnClickListener {
                try {
                    Thread.sleep(2000)
                } catch (ex: Exception) {
                }
            }
        }
    }
}