package com.tengfei.hilibrary.hilog;

import androidx.annotation.NonNull;

/**
 * @author 滕飞
 * date 2020/7/13 8:56 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public interface HiLogPrinter {

    void print(@NonNull HiLogConfig hiLogConfig,int level,String tag,@NonNull String printString);
}
