package com.tengfei.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tengfei.hilibrary.hilog.HiLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        HiLog.at("tmd","afasdfa")
    }
}