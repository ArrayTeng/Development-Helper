package com.tengfei.hilibrary.hilog;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author 滕飞
 * date 2020/7/8 5:00 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public class HiLog {

    public static void v(Object... content) {

    }

    public static void d(Object... content) {

    }

    public static void i(Object... content) {

    }

    public static void w(Object... content) {

    }

    public static void e(Object... content) {

    }

    public static void a(Object... content) {

    }


    public static void vt(String tag, Object... content) {

    }

    public static void dt(String tag, Object... content) {

    }

    public static void it(String tag, Object... content) {

    }

    public static void wt(String tag, Object... content) {

    }

    public static void et(String tag, Object... content) {

    }

    public static void at(String tag, Object... content) {
        log(HiLogType.a, tag, content);
    }


    private static void log(@HiLogType.LogType int type, String tag, Object... content) {
        HiLogConfig hiLogConfig = HiLogManager.instance().getHiLogConfig();
        if (!hiLogConfig.enable()) {
            return;
        }
        String logTag = tag == null ? hiLogConfig.global() : tag;
        String body = parseBody(content);
        Log.println(type, logTag, body);
    }

    private static String parseBody(@NonNull Object[] content) {
        StringBuilder sb = new StringBuilder();
        for (Object o : content) {
            sb.append(o.toString()).append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
