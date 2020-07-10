package com.tengfei.library

import android.app.Application
import com.tengfei.hilibrary.hilog.HiLogConfig
import com.tengfei.hilibrary.hilog.HiLogManager

/**
 * @author 滕飞
 * date 2020/7/10 8:57 AM
 * email arrayadapter.cn@outlook.com
 * description
 */

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        HiLogManager.instance().init(object:HiLogConfig(){
            override fun enable(): Boolean {
                return true
            }

            override fun global(): String {
                return "Test"
            }
        })
    }
}