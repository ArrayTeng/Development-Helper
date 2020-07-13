package com.tengfei.hilibrary.hilog;

/**
 * @author 滕飞
 * date 2020/7/13 8:59 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
class HiThreadFormat implements ILogFormat<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:"+data.getName();
    }
}
