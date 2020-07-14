package com.tengfei.library

import android.app.Application
import com.google.gson.Gson
import com.tengfei.hilibrary.hilog.HiConsolePrinter
import com.tengfei.hilibrary.hilog.HiLogConfig
import com.tengfei.hilibrary.hilog.HiLogConfig.JsonParse
import com.tengfei.hilibrary.hilog.HiLogManager

/**
 * @author 滕飞
 * date 2020/7/10 8:57 AM
 * email arrayadapter.cn@outlook.com
 * description
 */

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {
            override fun injectJson(): JsonParse {
                return JsonParse { src -> Gson().toJson(src) }
            }

            override fun enable(): Boolean {
                return true
            }

            override fun global(): String {
                return "Test"
            }

            override fun includeThread(): Boolean {
                return true
            }
        }, HiConsolePrinter())
    }
}