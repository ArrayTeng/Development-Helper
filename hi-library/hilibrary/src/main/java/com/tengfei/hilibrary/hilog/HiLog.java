package com.tengfei.hilibrary.hilog;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * @author 滕飞
 * date 2020/7/8 5:00 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public class HiLog {

    private static final String packageName = HiLog.class.getPackage().getName();

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
        HiLogConfig hiLogConfig = HiLogManager.getInstance().getHiLogConfig();
        if (!hiLogConfig.enable()) {
            return;
        }
        String logTag = tag == null ? hiLogConfig.global() : tag;

        StringBuilder builder = new StringBuilder();
        if (hiLogConfig.includeThread()) {
            //打印线程信息
            String threadInfo = HiLogConfig.HI_THREAD_FORMAT.format(Thread.currentThread());
            builder.append(threadInfo).append("\n");
        }
        if (hiLogConfig.stackTraceDepth() > 0) {
            //打印堆栈信息
            String stackTraceInfo = HiLogConfig.HI_STACK_TRACE_FORMAT.format(
                    HiStackTraceUtil.getCopyRealStackTrace(
                            new Throwable().getStackTrace(), packageName,
                            hiLogConfig.stackTraceDepth()));

            builder.append(stackTraceInfo).append("\n");
        }
        String body = parseBody(content, hiLogConfig);
        builder.append(body);
        List<HiLogPrinter> printers = hiLogConfig.hiLogPrinters() != null ? Arrays.asList(hiLogConfig.hiLogPrinters()) :
                HiLogManager.getInstance().getHiLogPrinters();
        if (printers == null) {
            return;
        }
        for (HiLogPrinter printer : printers) {
            //遍历所有的打印器并打印信息
            printer.print(hiLogConfig, type, logTag, builder.toString());
        }
    }

    private static String parseBody(@NonNull Object[] content, HiLogConfig config) {
        if (null != config.injectJson()) {
            return config.injectJson().toJson(content);
        }
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
