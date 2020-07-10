package com.tengfei.hilibrary.hilog;

/**
 * @author 滕飞
 * date 2020/7/8 5:00 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public abstract class HiLogConfig {

    private static final String DEFAULT_TAG = "HiLog";

    public boolean enable(){
        return true;
    }

    public String global(){
        return DEFAULT_TAG;
    }
}
