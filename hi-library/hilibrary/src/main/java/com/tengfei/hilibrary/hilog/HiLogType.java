package com.tengfei.hilibrary.hilog;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 滕飞
 * date 2020/7/8 4:50 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public class HiLogType {

    @IntDef({v, d, i, w, e, a})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogType {
    }

    public static final int v = Log.VERBOSE;
    public static final int d = Log.DEBUG;
    public static final int i = Log.INFO;
    public static final int w = Log.WARN;
    public static final int e = Log.ERROR;
    public static final int a = Log.ASSERT;


}
