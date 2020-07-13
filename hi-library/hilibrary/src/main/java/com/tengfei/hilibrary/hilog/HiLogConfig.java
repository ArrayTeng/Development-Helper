package com.tengfei.hilibrary.hilog;

/**
 * @author 滕飞
 * date 2020/7/8 5:00 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public abstract class HiLogConfig {

    public static int MAX_LEN = 512;

    public static final HiStackTraceFormat HI_STACK_TRACE_FORMAT = new HiStackTraceFormat();
    public static final HiThreadFormat HI_THREAD_FORMAT = new HiThreadFormat();

    public boolean includeThread(){
        return false;
    }

    public int stackTraceDepth(){
        return 5;
    }

    public JsonParse injectJson(JsonParse jsonParse){
        return null;
    }

    public HiLogPrinter[] hiLogPrinters(){
        return null;
    }

    private static final String DEFAULT_TAG = "HiLog";

    public boolean enable(){
        return true;
    }

    public String global(){
        return DEFAULT_TAG;
    }

    public interface JsonParse{

        String toJson(Object data);
    }
}
