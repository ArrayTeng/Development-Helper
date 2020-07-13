package com.tengfei.hilibrary.hilog;

import android.util.Log;

import androidx.annotation.NonNull;

import static com.tengfei.hilibrary.hilog.HiLogConfig.MAX_LEN;

/**
 * @author 滕飞
 * date 2020/7/13 9:39 PM
 * email arrayadapter.cn@outlook.com
 * description 控制台打印
 */
class HiConsolePrinter implements HiLogPrinter {
    @Override
    public void print(@NonNull HiLogConfig hiLogConfig, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        //打印行数
        int count = len / MAX_LEN;

        if (count > 0) {
            int index = 0;
            for (int i = 0; i < count; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index = index+MAX_LEN;
            }
            if (index!=len){
                Log.println(level, tag, printString.substring(index, len));
            }
        }
    }
}
